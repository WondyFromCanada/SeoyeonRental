/**
 * 
 */
package com.seoyeon.rental.customer.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.seoyeon.rental.customer.dao.CustomerFaqDao;

/**
 * @author dhkim
 *
 */
@Repository
public class CustomerFaqDaoImpl implements CustomerFaqDao{

	@Override
	public int insertCustomerFaqBoard(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.insert("insertCustomerFaqBoard", param);
	}

	@Override
	public List<Map<String, Object>> selectCustomerFaqBoardList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("selectCustomerFaqBoardList");
	}

	@Override
	public Map<String, Object> selectCustomerFaqBoard(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.selectOne("selectCustomerFaqBoard", postId);
	}

	@Override
	public int updateCustomerFaqBoard(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.update("updateCustomerFaqBoard", param);
	}

	@Override
	public int deleteCustomerFaqBoard(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.delete("deleteCustomerFaqBoard", postId);
	}
	

}
