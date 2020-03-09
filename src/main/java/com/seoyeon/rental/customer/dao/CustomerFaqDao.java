/**
 * 
 */
package com.seoyeon.rental.customer.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author dhkim
 *
 */
public interface CustomerFaqDao {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	**/
	int insertCustomerFaqBoard(SqlSessionTemplate sqlSession, Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	**/
	List<Map<String, Object>> selectCustomerFaqBoardList(SqlSessionTemplate sqlSession);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	**/
	Map<String, Object> selectCustomerFaqBoard(SqlSessionTemplate sqlSession, String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	**/
	int updateCustomerFaqBoard(SqlSessionTemplate sqlSession, Map<String, Object> param);

}
