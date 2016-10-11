package com.altarit.berry.persist.service;

import com.altarit.berry.model.entity.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    User findByUsername(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByUsername(String name);

    List<User> findAllUsers();

    boolean isUsernameUnique(Integer id, String sso);

}
