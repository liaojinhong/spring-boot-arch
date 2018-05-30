package com.me.demo.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.me.demo.common.Pagination;


/**
 * HibernateSQLQuery
 */
public class HibernateSQLQuery implements HibernateCallback {

    private String sql = null;

    private Pagination pagination = null;

    private List aliasList = new ArrayList();

    private List entityList = new ArrayList();

    public HibernateSQLQuery(String sql) {
        this(sql, null);
    }

    public HibernateSQLQuery(String sql, Pagination pagination) {
        this.sql = sql;
        this.pagination = pagination;
    }

    public Object doInHibernate(Session session) throws HibernateException,
            SQLException {
        SQLQuery query = session.createSQLQuery(sql);
        if(pagination != null) {
            query.setFirstResult(pagination.getStartPosition());
            query.setMaxResults(pagination.getRowsPerPage());
        }
        for(int i = 0; i < aliasList.size(); i++) {
            String alias = (String)aliasList.get(i);
            Class entity = (Class)entityList.get(i);
            query.addEntity(alias, entity);
        }
        List resultList = query.list();
        return resultList;
    }

    public void addEntityMapping(String alias, Class clazz) {
        aliasList.add(alias);
        entityList.add(clazz);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(HibernateSQLQuery.class.getName());
        stringBuffer.append("[");
        stringBuffer.append("sql=").append(sql);
        stringBuffer.append(",pagination=").append(pagination);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
