package com.company.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.dto.SboardDto;

@Repository
public class SboardDaoImpl implements SboardDao {
	@Autowired
	private SqlSession session;
	private static final String namespace = "com.company.mapper.SboardMapper";

	@Override
	public int insertSboard(SboardDto dto) throws Exception {
		return session.insert(namespace + ".insertSboard", dto);
	}
	@Override
	public List<SboardDto> selectSboardAll() throws Exception {
		return session.selectList(namespace + ".selectSboardAll");
	}

	@Override
	public SboardDto selectSboard(SboardDto dto) throws Exception {
		return session.selectOne(namespace + ".selectSboard", dto);
	}

	@Override
	public int updateSboardBhit(SboardDto dto) throws Exception {
		return session.update(namespace + ".updateSboardBhit", dto);
	}

	@Override
	public int updateSboard(SboardDto dto) throws Exception {
		return session.update(namespace + ".updateSboard", dto);
	}

	@Override
	public int deleteSboard(SboardDto dto) throws Exception {
		return session.update(namespace + ".deleteSboard", dto);
	}
	@Override
	public List<SboardDto> searchSboard(SboardDto dto) throws Exception {
		return session.selectList(namespace +".searchSboard", dto);
		
	}

}
