package com.example.pp.dao;

import com.example.pp.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u").getResultList();

    }
    @Override
    public User getUserById(int id) {
        User user = em.find(User.class, id);
        if (user==null)
        {
            throw new EntityNotFoundException();
        }
        return user;

    }
    @Override
    public void removeUser(User user) {
        User us = em.find(User.class, user.getId());
        if (user==null)
        {
            throw new EntityNotFoundException();
        }
        em.remove(us);

    }
    @Override
    public void updateUser(User user) {
        User updatedUser = em.find(User.class,  user.getId());
        if (updatedUser==null)
        {
            throw new EntityNotFoundException();
        }
        updatedUser.setAge(user.getAge());
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
    }
    @Override
    public void addUser(User user) {
        em.persist(user);
    }
}
