package com.me.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;


/**
 * 基于Hibernate的Dao实现基类
 */
public class BaseDaoHibernateImpl extends DaoSupport {

	private HibernateOperations hibernateTemplate;


	/**
	 * Set the Hibernate SessionFactory to be used by this DAO.
	 * Will automatically create a HibernateTemplate for the given SessionFactory.
	 * @see #createHibernateTemplate
	 * @see #setHibernateTemplate
	 */
	public final void setSessionFactory(SessionFactory sessionFactory) {
	  this.hibernateTemplate = createHibernateTemplate(sessionFactory);
	}

	/**
	 * Create a HibernateTemplate for the given SessionFactory.
	 * Only invoked if populating the DAO with a SessionFactory reference!
	 * <p>Can be overridden in subclasses to provide a HibernateTemplate instance
	 * with different configuration, or a custom HibernateTemplate subclass.
	 * @param sessionFactory the Hibernate SessionFactory to create a HibernateTemplate for
	 * @return the new HibernateTemplate instance
	 * @see #setSessionFactory
	 */
	protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	/**
	 * Return the Hibernate SessionFactory used by this DAO.
	 */
	public final SessionFactory getSessionFactory() {
		return (this.hibernateTemplate != null ? 
				((HibernateTemplate)this.hibernateTemplate).getSessionFactory() : null);
	}

	/**
	 * Set the HibernateTemplate for this DAO explicitly,
	 * as an alternative to specifying a SessionFactory.
	 * @see #setSessionFactory
	 */
	public  void setHibernateTemplate(HibernateOperations hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * Return the HibernateTemplate for this DAO,
	 * pre-initialized with the SessionFactory or set explicitly.
	 */
	public  HibernateOperations getHibernateTemplate() {
	  return hibernateTemplate;
	}

	protected final void checkDaoConfig() {
		if (this.hibernateTemplate == null) {
			throw new IllegalArgumentException("sessionFactory or hibernateTemplate is required");
		}
	}


    /**
	 * Get a Hibernate Session, either from the current transaction or a new one.
	 * The latter is only allowed if the "allowCreate" setting of this bean's
	 * HibernateTemplate is true.
	 * <p><b>Note that this is not meant to be invoked from HibernateTemplate code
	 * but rather just in plain Hibernate code.</b> Either rely on a thread-bound
	 * Session (via HibernateInterceptor), or use it in combination with
	 * <code>releaseSession</code>.
	 * <p>In general, it is recommended to use HibernateTemplate, either with
	 * the provided convenience operations or with a custom HibernateCallback
	 * that provides you with a Session to work on. HibernateTemplate will care
	 * for all resource management and for proper exception conversion.
	 * @return the Hibernate Session
	 * @throws DataAccessResourceFailureException if the Session couldn't be created
	 * @throws IllegalStateException if no thread-bound Session found and allowCreate false
	 * @see #releaseSession
	 * @see org.springframework.orm.hibernate3.SessionFactoryUtils#getSession(SessionFactory, boolean)
	 * @see org.springframework.orm.hibernate3.HibernateInterceptor
	 * @see org.springframework.orm.hibernate3.HibernateTemplate
	 * @see org.springframework.orm.hibernate3.HibernateCallback
	 */
	protected final Session getSession()
	    throws DataAccessResourceFailureException, IllegalStateException {

		return getSession(((HibernateTemplate)this.hibernateTemplate).isAllowCreate());
	}

	/**
	 * Get a Hibernate Session, either from the current transaction or
	 * a new one. The latter is only allowed if "allowCreate" is true.
	 * <p><b>Note that this is not meant to be invoked from HibernateTemplate code
	 * but rather just in plain Hibernate code.</b> Either rely on a thread-bound
	 * Session (via HibernateInterceptor), or use it in combination with
	 * <code>releaseSession</code>.
	 * <p>In general, it is recommended to use HibernateTemplate, either with
	 * the provided convenience operations or with a custom HibernateCallback
	 * that provides you with a Session to work on. HibernateTemplate will care
	 * for all resource management and for proper exception conversion.
	 * @param allowCreate if a non-transactional Session should be created when no
	 * transactional Session can be found for the current thread
	 * @return the Hibernate Session
	 * @throws DataAccessResourceFailureException if the Session couldn't be created
	 * @throws IllegalStateException if no thread-bound Session found and allowCreate false
	 * @see #releaseSession
	 * @see org.springframework.orm.hibernate3.SessionFactoryUtils#getSession(SessionFactory, boolean)
	 * @see org.springframework.orm.hibernate3.HibernateInterceptor
	 * @see org.springframework.orm.hibernate3.HibernateTemplate
	 * @see org.springframework.orm.hibernate3.HibernateCallback
	 */
	protected final Session getSession(boolean allowCreate)
	    throws DataAccessResourceFailureException, IllegalStateException {

		return (!allowCreate ?
		    SessionFactoryUtils.getSession(getSessionFactory(), false) :
				SessionFactoryUtils.getSession(
						getSessionFactory(),
						((HibernateTemplate)this.hibernateTemplate).getEntityInterceptor(),
						((HibernateTemplate)this.hibernateTemplate).getJdbcExceptionTranslator()));
	}

	/**
	 * Convert the given HibernateException to an appropriate exception from the
	 * <code>org.springframework.dao</code> hierarchy. Will automatically detect
	 * wrapped SQLExceptions and convert them accordingly.
	 * <p>Delegates to the <code>convertHibernateAccessException</code>
	 * method of this DAO's HibernateTemplate.
	 * <p>Typically used in plain Hibernate code, in combination with
	 * <code>getSession</code> and <code>releaseSession</code>.
	 * @param ex HibernateException that occured
	 * @return the corresponding DataAccessException instance
	 * @see #setHibernateTemplate
	 * @see #getSession
	 * @see #releaseSession
	 * @see org.springframework.orm.hibernate3.HibernateTemplate#convertHibernateAccessException
	 */
	protected final DataAccessException convertHibernateAccessException(HibernateException ex) {
		return ((HibernateTemplate)this.hibernateTemplate).convertHibernateAccessException(ex);
	}

	/**
	 * Close the given Hibernate Session, created via this DAO's SessionFactory,
	 * if it isn't bound to the thread.
	 * <p>Typically used in plain Hibernate code, in combination with
	 * <code>getSession</code> and <code>convertHibernateAccessException</code>.
	 * @param session Session to close
	 * @see org.springframework.orm.hibernate3.SessionFactoryUtils#releaseSession
	 */
	protected final void releaseSession(Session session) {
		SessionFactoryUtils.releaseSession(session, getSessionFactory());
	}
    /**
     * @deprecated please use hql
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * @deprecated please use hql
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @deprecated please use hql
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    protected List queryList(HibernateSQLQuery hsq) { 
        List list = getHibernateTemplate().executeFind(hsq);
        if(list == null) {
            list = new ArrayList();
        }
        return list;
    }
 
    protected Object queryUniqueObject(HibernateSQLQuery hsq) {
        List list = getHibernateTemplate().executeFind(hsq);
        if(list == null || list.size() == 0) {
            return null;
        }
        else {
            return list.get(0);
        }
    }

    protected Integer queryIntegerResult(HibernateSQLQuery hsq) {
        List list = getHibernateTemplate().executeFind(hsq);
        if(list == null || list.size() == 0) {
            return null;
        }
        else {
            return DataUtils.getInteger(list.get(0));
        }
    }

    protected int executeUpdate(HibernateSQLUpdate hsu) {
        Object object = getHibernateTemplate().execute(hsu);
        return DataUtils.getInteger(object).intValue();
    }
}