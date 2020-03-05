/**
 * 
 */
package com.seoyeon.rental.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.seoyeon.rental.customer.dao.CustomerQuestionDao;

/**
 * @author dhkim
 *
 */
@Repository
public class CustomerQuestionDaoImpl implements CustomerQuestionDao{

	@Override
	public int insertCustomerQuestionBoard(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.insert("insertCustomerQuestionBoard", param);
	}

	@Override
	public List<Map<String, Object>> selectCustomerQuestionBoardList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("selectCustomerQuestionBoardList");
	}

	@Override
	public Map<String, Object> selectCustomerQuestionBoard(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.selectOne("selectCustomerQuestionBoard", postId);
	}

	@Override
	public int updateCustomerQuestionBoard(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.update("updateCustomerQuestionBoard", param);
	}

	@Override
	public int deleteCustomerQuestionBoard(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.delete("deleteCustomerQuestionBoard", postId);
	}


}
