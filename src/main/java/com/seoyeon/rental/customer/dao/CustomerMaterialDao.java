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
public interface CustomerMaterialDao {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 
	**/
	int insertCustomerMaterial(SqlSessionTemplate sqlSession, Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 
	**/
	int insertAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 10.
	 *  Discription : 
	**/
	List<Map<String, Object>> selectCustomerMaterialBoardList(SqlSessionTemplate sqlSession);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 10.
	 *  Discription : 
	**/
	Map<String, Object> selectCustomerMaterialBoard(SqlSessionTemplate sqlSession, String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 15.
	 *  Discription : 
	**/
	List<Map<String, Object>> getGridColInf(SqlSessionTemplate sqlSession, Map<String, Object> param);

}
