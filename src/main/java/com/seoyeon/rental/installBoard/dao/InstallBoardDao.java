/**
 * 
 */
package com.seoyeon.rental.installBoard.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author dhkim
 *
 */
public interface InstallBoardDao {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 
	**/
	int insertInstallBoard(SqlSessionTemplate sqlSession, Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 
	**/
	List<Map<String, Object>> selectInstallBoardList(SqlSessionTemplate sqlSession);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 
	**/
	Map<String, Object> selectInstallBoard(SqlSessionTemplate sqlSession, String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 
	**/
	int deleteInstallBoard(SqlSessionTemplate sqlSession, String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 
	**/
	int updateInstallBoard(SqlSessionTemplate sqlSession, Map<String, Object> param);

}
