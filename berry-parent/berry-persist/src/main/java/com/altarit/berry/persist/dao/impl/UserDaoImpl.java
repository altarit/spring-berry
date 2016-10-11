package com.altarit.berry.persist.dao.impl;

import com.altarit.berry.model.entity.User;
import com.altarit.berry.persist.dao.AbstractDao;
import com.altarit.berry.persist.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User findById(int id) {
        User user = getByKey(id);
        if (user != null) {
            initializeCollection(user.getUserProfiles());
        }
        return user;
    }

    public User findByUsername(String name) {
        System.out.println("SSO : " + name);
        try {
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.username LIKE :username")
                    .setParameter("username", name)
                    .getSingleResult();

            if (user != null) {
                initializeCollection(user.getUserProfiles());
            }
            return user;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.username ASC")
                .getResultList();
        return users;
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteByUsername(String name) {
        User user = (User) getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.username LIKE :username")
                .setParameter("username", name)
                .getSingleResult();
        delete(user);
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if (collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}