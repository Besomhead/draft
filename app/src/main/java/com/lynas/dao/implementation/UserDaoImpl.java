package com.lynas.dao.implementation;

import com.lynas.dao.UserDao;
import com.lynas.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by alex on 16.4.17.
 */
public class UserDaoImpl implements UserDao{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User loadUserByUsername(String username) {
        return (User) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("username", username))
                .uniqueResult();
    }

    @Override
    public long saveUser(User user) {
        user.setAuthorities("USER");
        return (long) sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public User get(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
