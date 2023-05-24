package com.example.tobyspring3.dao;

import com.example.tobyspring3.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        User user = new User();
        user.setId("5");
        user.setName("maru");
        user.setPassword("12345678");
        userDao.add(user);

        User selectedUser = userDao.get("5");
        System.out.printf("%s %s %s\n", selectedUser.getId(), selectedUser.getName(), selectedUser.getPassword());
    }
}
