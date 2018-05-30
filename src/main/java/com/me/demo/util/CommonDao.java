package com.me.demo.util;

/**
 * Common Dao
 */
public interface CommonDao {

	//	session.flush();强制与数据库同步
	//	session.clear();清除session缓存，不包括操作中的对象
	//	session.evict(obj) ：会把指定的缓冲对象进行清除
	
    public void evict(Object object);

    public void flush();

    // 判断列是否存在
    public boolean hasColumn(String tableName, String columnName);
 
    // 获得查询的记录
    public int getCount(String fromToWhere);
}
