package com.JdbcTemplate.dao;

import com.JdbcTemplate.enity.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);

    List<User> getUserList();

    int add(User user);

    int update(Integer id, User user);

    int delete(Integer id);
}
