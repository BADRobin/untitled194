package com.company.dao;

import com.company.Course;
import com.company.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    public Course find(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from course where id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Course(rs.getInt(1), rs.getString(2), rs.getInt(3));
            } else {
                return new Course();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new Course();
        }
    }

    public List<Course> findByTeacher(Teacher teacher) {
        List<Course> courses = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("select course.id, course.title, course.duration from course, teacher_has_course where course_id=teacher_has_course.course_id and teacher_has_course.teacher_id = ?")) {
            ps.setInt(1, teacher.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Course course = new Course(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        teacher.setCourses(courses);
        return courses;
    }

}
