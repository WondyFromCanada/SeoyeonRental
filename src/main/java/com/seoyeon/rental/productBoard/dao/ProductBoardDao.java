/**
 * 
 */
package com.seoyeon.rental.productBoard.dao;

import java.util.List;
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

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 16.
	 *  Discription : 
	**/
	List<Map<String, Object>> selectProductBoardRentalMfp(SqlSessionTemplate sqlSession);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 16.
	 *  Discription : 
	**/
	Map<String, Object> selectProductBoardRentalMfpDetail(SqlSessionTemplate sqlSession, String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 16.
	 *  Discription : 
	**/
	int updateProductBoardRentalMfp(SqlSessionTemplate sqlSession, Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 16.
	 *  Discription : 
	**/
	int deleteProductBoardRentalMfp(SqlSessionTemplate sqlSession, String postId);

}
