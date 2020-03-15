/**
 * 
 */
package com.seoyeon.rental.customer.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.seoyeon.rental.customer.dao.CustomerMaterialDao;

/**
 * @author dhkim
 *
 */
@Repository
public class CustomerMaterialDaoImpl implements CustomerMaterialDao{

	@Override
	public int insertCustomerMaterial(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.insert("insertCustomerMaterial", param);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap) {
		return sqlSession.insert("insertAttachment", attMap);
	}

	@Override
	public List<Map<String, Object>> selectCustomerMaterialBoardList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("selectCustomerMaterialBoardList");
	}

	@Override
	public Map<String, Object> selectCustomerMaterialBoard(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.selectOne("selectCustomerMaterialBoard", postId);
	}

	@Override
	public List<Map<String, Object>> getGridColInf(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.selectList("getGridColInf", param);
	}

}
