package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO {
    private Connection connection;

    public TeacherDAO(Connection connection) {
        this.connection = connection;
    }

    public Teacher find(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from teacher where id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Teacher(rs.getInt(1), rs.getString(2), rs.getInt(3));
            } else {
                return new Teacher();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new Teacher();
        }
    }
}
