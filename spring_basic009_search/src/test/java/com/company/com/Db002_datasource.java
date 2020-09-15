package com.company.com;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class Db002_datasource {
	@Autowired
	private DataSource ds;
	
	@Test
	public void test() throws Exception{
		try {
			Connection conn = ds.getConnection();
			if(conn!=null) {System.out.println("datasource!");}
		}catch(Exception e) {e.printStackTrace();}
	}
}