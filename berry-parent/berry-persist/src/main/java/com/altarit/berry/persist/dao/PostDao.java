package com.altarit.berry.persist.dao;


import com.altarit.berry.model.entity.Post;

import java.util.List;

public interface PostDao {

    Post findById(int id);

    void save(Post post);

    List<Post> findAllPosts();
}
