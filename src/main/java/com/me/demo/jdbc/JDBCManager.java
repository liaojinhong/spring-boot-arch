package com.me.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*<dependency>
 <groupId>com.oracle</groupId>
 <artifactId>ojdbc14</artifactId>
 <version>10.2</version>
 </dependency>*/
// 安装本地jar包到maven库：
// mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2 -Dpackaging=jar -Dfile=D:\code\spring-boot\locallib\ojdbc14.jar
public class JDBCManager {

	public static JDBCManager jdbcManager;

	// 禁止实例化
	private JDBCManager() {
	}
	
	// 获得对象（单例）
	public static JDBCManager getInstance() {
		if (jdbcManager == null) {
			jdbcManager = new JDBCManager();
		}
		return jdbcManager;
	}

	/**
	 * 获得连接Connection
	 * @return
	 */
	public static Connection getConnection() {
		// 注册驱动
		String driver = "oracle.jdbc.OracleDriver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 连接数据库
		String url = "jdbc:oracle:thin:@172.40.1.60:1528:UAT11GMAPROD";
		String user = "YT_SALES";
		String pwd = "ytsales.11g";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 获得Statement
	 * @return
	 */
	public static Statement getStatement() {
		// 获得连接
		Connection conn = getConnection();
		// 创建Statement
		Statement st = null;
		try {
		    st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void closeConn(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

	public static void main(String[] args) throws Exception {
		Connection conn = JDBCManager.getConnection();
		Statement st = conn.createStatement();
		// 执行SQL(dql)
		String sql = "select g.comcode,g.comcname from prpdcompany g";
		ResultSet rs = st.executeQuery(sql);
		// rs结果集中包含一个游标,游标默认在结果集的第一行之前
		// rs.next():移动结果集游标到下一行，检查是否有数据, 如果有返回true, 否则false
		while (rs.next()) {
			// getXXX(列名): 返回结果集当前行中
			// 指定列名的数据.
			String comcode = rs.getString("comcode");
			String comcname = rs.getString("comcname");
			// 输出查询结果
			System.out.println(comcode + "," + comcname);
		}
		// 关闭连接
		JDBCManager.closeConn(conn);
	}

}
