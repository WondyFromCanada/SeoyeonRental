/**
 * 
 */
package com.seoyeon.rental.productBoard.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author dhkim
 *
 */
public interface ProductBoardDao {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 15.
	 *  Discription : 
	**/
	int insertProductBoardRentalMfp(SqlSessionTemplate sqlSession, Map<String, Object> param);

}
