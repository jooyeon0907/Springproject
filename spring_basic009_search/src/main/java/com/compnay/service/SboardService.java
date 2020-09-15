package com.compnay.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.company.dto.SboardDto;

public interface SboardService {
	public List<SboardDto> searchSboard(SboardDto dto) throws Exception;
//	public int			insertSboard(SboardDto dto)    throws Exception;
	public int insertSboard(MultipartFile file, SboardDto dto, HttpServletRequest request) throws Exception;
	public List<SboardDto> selectSboardAll()     		   throws Exception;
	public SboardDto	selectSboard(SboardDto dto)    throws Exception;
	public int			updateSboardBhit(SboardDto dto)throws Exception;
	public int			updateSboard(SboardDto dto)    throws Exception;
	public int			deleteSboard(SboardDto dto)    throws Exception;
}
