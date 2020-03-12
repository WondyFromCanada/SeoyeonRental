package com.seoyeon.rental.product.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.seoyeon.rental.product.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Override
	public int insertProductMfp(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.insert("insertProductMfp", param);
	}

	@Override
	public int insertProductMfpAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap) {
		return sqlSession.insert("insertProductMfpAttachment", attMap);
	}

	@Override
	public int insertProductExpd(SqlSessionTemplate sqlSession, Map<String, Object> param) {
		return sqlSession.insert("insertProductExpd", param);
	}

	@Override
	public int insertProductExpdAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap) {
		return sqlSession.insert("insertProductExpdAttachment", attMap);
	}

	@Override
	public List<Map<String, Object>> selectProductMfpList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("selectProductMfpList");
	}

	@Override
	public List<Map<String, Object>> selectProductExpdList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("selectProductExpdList");
	}

	@Override
	public int selectProductMfpListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("selectProductMfpListCount");
	}

	@Override
	public int selectProductExpdListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("selectProductExpdListCount");
	}
	
}
