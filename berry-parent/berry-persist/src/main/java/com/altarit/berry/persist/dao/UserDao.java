package com.altarit.berry.persist.dao;


import com.altarit.berry.model.entity.User;

import java.util.List;


public interface UserDao {

    User findById(int id);

    User findByUsername(String name);

    void save(User user);

    void deleteByUsername(String name);

    List<User> findAllUsers();

}
