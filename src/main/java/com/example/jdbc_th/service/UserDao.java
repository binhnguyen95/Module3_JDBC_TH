package com.example.jdbc_th.service;

import com.example.jdbc_th.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao{
    private final String jdbcURL = "jdbc:mysql://localhost:3306/JDBC_TH";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "chetdicon";

    private static final String INSERT_USERS_SQL = "INSERT INTO users(name, email, country) VALUES (?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";


    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection successful!!!!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error!!!!");
        }
        return connection;
    }

    @Override
    public void insertUser(User users) {
        System.out.println(INSERT_USERS_SQL);
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL)
                )
        {
            statement.setString(1, users.getName());
            statement.setString(2, users.getEmail());
            statement.setString(3, users.getCountry());
            System.out.println(statement);
            statement.executeUpdate();
            System.out.println("INSERT THANH CONG");
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser(){
        List<User> users = new ArrayList<>();
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                User user = new User(id, name, email, address);
                users.add(user);
            }
            System.out.println("Da chay ALO ALO!!!!");
        } catch (SQLException e) {
            System.err.println("ERROR!!!!");
        }
        ;


        return users;
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
        User users = new User(1, "alo", "alo@yahoo", "ALO" );
        UserDao userDao = new UserDao();

        userDao.insertUser(users);

    }
}
