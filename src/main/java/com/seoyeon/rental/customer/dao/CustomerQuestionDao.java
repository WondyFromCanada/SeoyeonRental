/**
 * 
 */
package com.seoyeon.rental.customer.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.seoyeon.rental.common.PageInfo;

/**
 * @author dhkim
 *
 */
public interface CustomerQuestionDao {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	**/
	int insertCustomerQuestionBoard(SqlSessionTemplate sqlSession, Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	 * @param pi 
	**/
	List<Map<String, Object>> selectCustomerQuestionBoardList(SqlSessionTemplate sqlSession);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	**/
	Map<String, Object> selectCustomerQuestionBoard(SqlSessionTemplate sqlSession, String postId);

}
