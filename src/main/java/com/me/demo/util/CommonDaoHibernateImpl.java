package com.me.demo.util;

import java.util.*;

/**
 * CommonDaoHibernateImpl
 */
public class CommonDaoHibernateImpl extends BaseDaoHibernateImpl implements
        CommonDao {
    private static Map map = Collections.synchronizedMap(new HashMap());

    /**
     * 检查表是否含有列
     * 
     * @param tableName 表名
     * @param columnName 列名
     * @return 存在列返回true,否则返回false
     */
    public boolean hasColumn(String tableName, String columnName) {
        boolean result = true;
        tableName = tableName.toLowerCase();
        columnName = columnName.toLowerCase();
        String key = tableName + "|" + columnName;
        if(map.containsKey(key)) {
            return ((Boolean)map.get(key)).booleanValue();
        }
        StringBuffer sql = new StringBuffer(100);
        sql.append("select " + columnName + " from " + tableName
                + " where 1=0 ");

        try {

            HibernateSQLQuery hsq = new HibernateSQLQuery(sql.toString());
            this.queryList(hsq);
        }
        catch(Throwable e) {
            result = false;
        }
        map.put(key, Boolean.valueOf(result));
        return result;
    }

    /**
     * @see com.chinainsurance.sysframework.persistence.CommonDao#evict(java.lang.Object)
     */
    public void evict(Object object) {
        if(object != null) {
            this.getHibernateTemplate().evict(object);
        }
    }

    public void flush() {
        this.getHibernateTemplate().flush();
    }

    /**
     * 得到count值 
     */
    public int getCount(String fromToWhere) {
        int count = 0;
        StringBuffer sql = new StringBuffer(100);
        sql.append("select count(*) ");
        sql.append(fromToWhere);
        HibernateSQLQuery hsq = new HibernateSQLQuery(sql.toString());
        count = this.queryIntegerResult(hsq).intValue();
        return count;
    }
}
