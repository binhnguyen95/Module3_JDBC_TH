package com.example.jdbc_th.service;

import com.example.jdbc_th.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public void insertUser(User users) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUser() throws SQLException;

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User users) throws SQLException;

}
