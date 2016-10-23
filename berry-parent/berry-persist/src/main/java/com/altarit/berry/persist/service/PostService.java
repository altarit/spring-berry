package com.altarit.berry.persist.service;


import com.altarit.berry.model.entity.Post;

import java.util.List;

public interface PostService {

    Post findById(int id);

    void savePost(Post post);

    void updatePost(Post post);

    List<Post> findAllPosts();
}
