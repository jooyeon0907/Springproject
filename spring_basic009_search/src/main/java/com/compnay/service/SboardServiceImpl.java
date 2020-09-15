package com.compnay.service;

import java.io.File;
import java.net.InetAddress;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.company.dao.SboardDao;
import com.company.dto.SboardDto;

@Service
public class SboardServiceImpl implements SboardService {
	@Autowired
	private SboardDao dao;

	@Override
	public int insertSboard(MultipartFile file,SboardDto dto, HttpServletRequest request) throws Exception {
		System.out.println("ㅁname : "  + file.getOriginalFilename());
		System.out.println("ㅁsize : " +  file.getSize());
		System.out.println("ㅁcountentType " + file.getContentType());
		//1. 파일이름 중복되지않게 처리
		UUID uid = UUID.randomUUID();
		String filename = uid.toString() +"_" + file.getOriginalFilename();
	
		String uploadpath = request.getSession().getServletContext().getRealPath("/")+"upload";
		System.out.println("ㅁuploadpath : "  + uploadpath);
		
		//2. 파일업로드
		File target = new File( uploadpath, filename ); //File(파일경로, 파일이름)
		FileCopyUtils.copy(file.getBytes(), target);
		
		dto.setBfile(filename);
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		
		return dao.insertSboard(dto);
	} 
	@Override
	public List<SboardDto> selectSboardAll() throws Exception {
		return dao.selectSboardAll();
	}

	@Override
	public SboardDto selectSboard(SboardDto dto) throws Exception {
		return dao.selectSboard(dto);
	}

	@Override
	public int updateSboardBhit(SboardDto dto) throws Exception {
		return dao.updateSboardBhit(dto);
	}

	@Override
	public int updateSboard(SboardDto dto) throws Exception {
		return dao.updateSboard(dto);
	}

	@Override
	public int deleteSboard(SboardDto dto) throws Exception {
		return dao.deleteSboard(dto);
	}
	@Override
	public List<SboardDto> searchSboard(SboardDto dto) throws Exception {
		return dao.searchSboard(dto);
	}
	
	

}
