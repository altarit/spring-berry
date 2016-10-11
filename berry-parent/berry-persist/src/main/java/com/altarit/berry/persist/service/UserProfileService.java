package com.altarit.berry.persist.service;

import com.altarit.berry.model.entity.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();

}
