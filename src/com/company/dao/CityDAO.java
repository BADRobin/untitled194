package com.company.dao;

import com.company.City;
import com.company.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    private Connection connection;

    public CityDAO(Connection connection) {
        this.connection = connection;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from city");
            while (resultSet.next()) {
                cities.add(new City(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public List<Teacher> findByCity(City city) {
        List<Teacher> teachers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from teacher where city_id = ?")) {
            preparedStatement.setInt(1, city.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                teacher.setCity(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        city.setTeachers(teachers);
        return teachers;
    }
}
