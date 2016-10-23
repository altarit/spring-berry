package com.altarit.berry.persist.service.impl;


import com.altarit.berry.model.entity.Post;
import com.altarit.berry.persist.dao.PostDao;
import com.altarit.berry.persist.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao dao;

    @Override
    public Post findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void savePost(Post post) {
        dao.save(post);
    }

    @Override
    public void updatePost(Post post) {
        if (post.getId() == null) {
            return;
        }
        Post entity = dao.findById(post.getId());
        if (entity != null) {
            entity.setTitle(post.getTitle());
            entity.setSource(post.getSource());
        } else {
            //TODO: handle when there is no entity
        }
    }

    @Override
    public List<Post> findAllPosts() {
        return dao.findAllPosts();
    }
}
