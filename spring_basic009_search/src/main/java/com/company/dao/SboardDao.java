package com.company.dao;

import java.util.List;

import com.company.dto.SboardDto;

public interface SboardDao {
	public List<SboardDto> searchSboard(SboardDto dto) throws Exception;
	
	public int			insertSboard(SboardDto dto)    throws Exception;
	public List<SboardDto> selectSboardAll()     		   throws Exception;
	public SboardDto	selectSboard(SboardDto dto)    throws Exception;
	public int			updateSboardBhit(SboardDto dto)throws Exception;
	public int			updateSboard(SboardDto dto)    throws Exception;
	public int			deleteSboard(SboardDto dto)    throws Exception;
}
