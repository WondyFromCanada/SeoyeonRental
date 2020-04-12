/**
 * 
 */
package com.seoyeon.rental.installBoard.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.seoyeon.rental.installBoard.dao.InstallBoardDao;

/**
 * @author dhkim
 *
 */
@Repository
public class InstallBoardDaoImpl implements InstallBoardDao{

	@Override
	public int insertInstallBoard(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.insert("insertInstallBoard", param);
	}

	@Override
	public List<Map<String, Object>> selectInstallBoardList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("selectInstallBoardList");
	}

	@Override
	public Map<String, Object> selectInstallBoard(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.selectOne("selectInstallBoard", postId);
	}

	@Override
	public int deleteInstallBoard(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.delete("deleteInstallBoard", postId);
	}

	@Override
	public int updateInstallBoard(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.update("updateInstallBoard", param);
	}

}
