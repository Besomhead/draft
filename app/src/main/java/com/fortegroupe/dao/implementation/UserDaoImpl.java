package com.fortegroupe.dao.implementation;

import com.fortegroupe.dao.UserDao;
import com.fortegroupe.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alex on 13.4.17.
 */
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User registerUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        if(checkEmail(user.getEmail())){
           throw new ServiceException("This user are exist!");
        }else {
            session.persist(user);
        }

        User daoUser = getUserByEmail(user.getEmail());
        return daoUser;
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User WHERE email=:usrEmail");
        query.setParameter("usrEmail",email);

        List users = query.list();
        if(!users.isEmpty())
            return (User) users.get(0);
        else
            return null;
    }

    @Override
    @Transactional
    public boolean checkEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User WHERE email=:usrEmail");
        query.setParameter("usrEmail",email);
        return !query.list().isEmpty();
    }


}
