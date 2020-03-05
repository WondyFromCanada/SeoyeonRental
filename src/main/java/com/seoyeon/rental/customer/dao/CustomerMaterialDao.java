/**
 * 
 */
package com.seoyeon.rental.customer.dao;

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

}
