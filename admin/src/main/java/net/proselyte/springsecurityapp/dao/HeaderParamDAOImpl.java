package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.HeaderParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class HeaderParamDAOImpl implements HeaderParamDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public HeaderParam getHeaderParam(int pId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        HeaderParam headerParam =  (HeaderParam) session.get(HeaderParam.class, pId);
        transaction.commit();
        return headerParam;
    }

    @Override
    public void setHeaderParam(HeaderParam pHeaderParam) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(pHeaderParam);
        transaction.commit();
    }

    @Override
    public void editHeaderParam(int pId, HeaderParam pHeaderParam) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        pHeaderParam.setId(((HeaderParam)session.get(HeaderParam.class, pId)).getId());
        sessionFactory.getCurrentSession().update(pHeaderParam);
        transaction.commit();
    }

    @Override
    public void deleteHeaderParam(int pId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(HeaderParam.class, pId));
        transaction.commit();
    }
}
