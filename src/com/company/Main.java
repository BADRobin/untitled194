package com.company;

import com.company.dao.CityDAO;
import com.company.dao.CourseDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    CityDAO cityDAO;
    CourseDAO courseDAO;
    TeacherDAO teacherDAO;


    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        try {
            initConnection();
//            Course course = courseDAO.find(2);
             Teacher teacher = teacherDAO.find(1);
             courseDAO.findByTeacher(teacher);
            System.out.println("Teacher: " + teacher.getFio());
            for (Course course : teacher.getCourses()) {
                System.out.println(course.getId() + " " + course.getTitle());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "eugeny", "123");
        cityDAO = new CityDAO(connection);
        courseDAO = new CourseDAO(connection);
        teacherDAO = new TeacherDAO(connection);
    }
}
