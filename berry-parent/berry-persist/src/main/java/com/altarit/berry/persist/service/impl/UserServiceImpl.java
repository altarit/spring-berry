package com.altarit.berry.persist.service.impl;

import com.altarit.berry.model.entity.User;
import com.altarit.berry.persist.dao.UserDao;
import com.altarit.berry.persist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public User findByUsername(String name) {
        return dao.findByUsername(name);
    }

    @Override
    public void saveUser(User user) {
        dao.save(user);
    }

    @Override
    public void updateUser(User user) {
        if (user.getId() == null) {
            return;
        }
        User entity = dao.findById(user.getId());
        if (entity != null) {
            //entity.se(user.getSsoId());
            entity.setPassword(user.getPassword());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        } else {
            //TODO: handle this cause
        }
    }

    @Override
    public void deleteUserByUsername(String name) {
        dao.deleteByUsername(name);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public boolean isUsernameUnique(Integer id, String name) {
        User entity = dao.findByUsername(name);
        return (entity == null || (id != null) && (entity.getId() == id));
    }
}
