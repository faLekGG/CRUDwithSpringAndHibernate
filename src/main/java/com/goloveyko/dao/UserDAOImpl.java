package com.goloveyko.dao;

import com.goloveyko.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(user);
    }

    /*@Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.update(user);
    }*/

    @Override
    public List<User> searchUsers(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery = currentSession.createQuery("from User where firstName like :theName or lastName like :theName", User.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery = currentSession.createQuery("from User", User.class);
        }

        // execute query and get result list
        List<User> users = theQuery.getResultList();

        // return the results
        return users;

    }

    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.load(User.class, id);

        if(user != null)
            session.delete(user);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, id);

        return user;
    }

    @Override
    public List<User> users() {
        Session session = sessionFactory.getCurrentSession();

        List<User> users = session.createQuery("from User order by lastName", User.class).list();

        return users;
    }
}
