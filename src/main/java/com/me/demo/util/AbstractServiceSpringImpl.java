/*
 * ServiceSpringImpl的公共抽象父类
 */
package com.me.demo.util;

import org.hibernate.SessionFactory;

public class AbstractServiceSpringImpl {

    private SessionFactory sessionFactory = null;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
