package com.example.jdbc_th.service;

import com.example.jdbc_th.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao{
    private String jdbcURL = "jdbc:mysql://localhost:3306/JDBC_TH";
    private String jdbcUsername = "root";
    private String jdbcPassword = "chetdicon";


    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return connection;
    }

    @Override
    public void insertUser(User users) throws SQLException {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User users) throws SQLException {
        return false;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.getConnection();
    }
}
