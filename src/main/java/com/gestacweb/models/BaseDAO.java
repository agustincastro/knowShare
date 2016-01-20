package com.gestacweb.models;

import com.gestacweb.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public abstract class BaseDAO<T> implements DAO<T> {

    private Session session;//= HibernateUtil.getSessionFactory().getCurrentSession(); // = HibernateUtil.getSessionFactory().openSession();

    public BaseDAO(){}

    protected Session getSession() {
        if(session != null)
            return session;
        else
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }

    @Override
    public void save(T entity){
        Session session = getSession();
        Transaction t = session.beginTransaction();
        try{
            session.save(entity);
            t.commit();
        }catch(HibernateException e){
            e.printStackTrace();
            t.rollback();
        }
    }

    @Override
    public void update(T entity) {
        Session session = getSession();
        Transaction t = session.beginTransaction();
        try{
            session.update(entity);
            t.commit();
        }catch(HibernateException e){
            e.printStackTrace();
            t.rollback();
        }
    }

    @Override
    public void delete(T entity) {
        Session session = getSession();
        Transaction t = session.beginTransaction();
        try{
            session.update(entity);
            t.commit();
        }catch(HibernateException e){
            e.printStackTrace();
            t.rollback();
        }
    }

}
