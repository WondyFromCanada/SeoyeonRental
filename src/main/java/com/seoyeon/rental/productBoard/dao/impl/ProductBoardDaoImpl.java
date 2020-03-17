/**
 * 
 */
package com.seoyeon.rental.productBoard.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.seoyeon.rental.productBoard.dao.ProductBoardDao;

/**
 * @author dhkim
 *
 */

@Repository
public class ProductBoardDaoImpl implements ProductBoardDao{

	@Override
	public int insertProductBoardRentalMfp(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.insert("insertProductBoardRentalMfp", param);
	}

	@Override
	public List<Map<String, Object>> selectProductBoardRentalMfp(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("selectProductBoardRentalMfp");
	}

	@Override
	public Map<String, Object> selectProductBoardRentalMfpDetail(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.selectOne("selectProductBoardRentalMfpDetail", postId);
	}

	@Override
	public int updateProductBoardRentalMfp(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.update("updateProductBoardRentalMfp", param);
	}

	@Override
	public int deleteProductBoardRentalMfp(SqlSessionTemplate sqlSession, String postId) {
		return sqlSession.delete("deleteProductBoardRentalMfp", postId);
	}

}
