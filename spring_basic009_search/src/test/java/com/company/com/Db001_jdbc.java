package com.company.com;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class Db001_jdbc {
	@Test
	public void test() throws ClassNotFoundException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/db0","root","1234");
			if(conn!=null) {System.out.println("SPRING_JDBC연동성공");}
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
