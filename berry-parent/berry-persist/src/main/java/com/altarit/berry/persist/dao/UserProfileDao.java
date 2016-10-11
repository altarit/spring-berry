package com.altarit.berry.persist.dao;

import java.util.List;

import com.altarit.berry.model.entity.UserProfile;


public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);

}