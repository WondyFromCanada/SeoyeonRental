package com.seoyeon.rental.product.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface ProductDao {

	int insertProductMfp(SqlSessionTemplate sqlSession, Map<String, Object> param);

	int insertProductMfpAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap);

	int insertProductExpd(SqlSessionTemplate sqlSession, Map<String, Object> param);

	int insertProductExpdAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap);

}
