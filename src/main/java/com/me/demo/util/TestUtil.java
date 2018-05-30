package com.me.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestUtil {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@172.10.1.1:1521:orcl";
		String user = "sales";
		String pwd = "sales.11g";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement st = conn.createStatement();
		String sql = "select * from prpdcompany;";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			rs.getString("comname");
		}
		conn.close();
	}
	
	
}
