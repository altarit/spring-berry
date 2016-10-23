package com.altarit.berry.persist.dao.impl;


import com.altarit.berry.model.entity.Post;
import com.altarit.berry.persist.dao.AbstractDao;
import com.altarit.berry.persist.dao.PostDao;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("postDao")
public class PostDaoImpl extends AbstractDao<Integer, Post> implements PostDao {
    @Override
    public Post findById(int id) {
        try {
            Post post = (Post) getEntityManager()
                    .createQuery("SELECT p FROM Post p WHERE p.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
            return post;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(Post post) {
        persist(post);

    }

    @Override
    public List<Post> findAllPosts() {
        List<Post> posts = getEntityManager()
                .createQuery("SELECT p FROM Post p ORDER BY p.id")
                .getResultList();
        return posts;
    }
}
