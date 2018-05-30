package com.me.demo.util;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * class comments write here...
 * 
 * @version created date: 2006-10-26 11:01:50
 */
public class HibernateSQLUpdate implements HibernateCallback {

    private String hql = null;

    public HibernateSQLUpdate(String hql) {
        this.hql = hql;
    }

    public Object doInHibernate(Session session) throws HibernateException,
            SQLException {
        Query query = session.createQuery(hql);
        int i = query.executeUpdate();
        return new Integer(i);
    }
}
