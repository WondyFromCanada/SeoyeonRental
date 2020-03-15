/**
 * 
 */
package com.seoyeon.rental.productBoard.dao.impl;

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

}
