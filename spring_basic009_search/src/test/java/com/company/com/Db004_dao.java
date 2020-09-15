package com.company.com;

import java.net.InetAddress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.SboardDao;
import com.company.dto.SboardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class Db004_dao {

	@Autowired
	private SboardDao dao;

	
	@Test
	public void test_selectAll() throws Exception{
		SboardDto dto = new SboardDto();
		dto.setBtitle("1");
		System.out.println(dao.searchSboard(dto));
	}
	
	
//	@Test 
//	public void test_insert() throws Exception {
//		SboardDto dto = new SboardDto();
//		dto.setBname("aaa"); dto.setBpass("111");
//		dto.setBtitle("title"); dto.setBcontent("content"); 
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		dto.setBfile("no.jsp");
//		System.out.println(dao.insertSboard(dto));
//	}

//	@Test 
//	public void test_selectAll() throws Exception{
//		System.out.println(dao.selectSboardAll());
//	}

//	@Test 
//	public void test_select() throws Exception{
//		SboardDto dto = new SboardDto();
//		dto.setBno(1); 
//		System.out.println(dao.selectSboard(dto));
//	}

//	@Test 
//	public void test_updatehit() throws Exception{
//		SboardDto dto = new SboardDto();
//		dto.setBno(1);
//		System.out.println(dao.updateSboardBhit(dto));
//	}

//	@Test
//	public void test_update() throws Exception {
//		SboardDto dto = new SboardDto();
//		dto.setBno(1);
//		dto.setBtitle("new");
//		dto.setBcontent("new");
//		dto.setBpass("111");
//		System.out.println(dao.updateSboard(dto));
//	}


//	  @Test public void test_delete() throws Exception{ SboardDto dto = new
//	  SboardDto(); dto.setBno(1); dto.setBpass("111");
//	  System.out.println(dao.deleteSboard(dto)); }
	
	
//	@Transactional(isolation=Isolation.READ_COMMITTED)
//	@Test 
//	@Rollback(false)
//	public void test_select() throws Exception{
//		System.out.println(dao.selectSboardAll());
//	}
	
	
	
}
