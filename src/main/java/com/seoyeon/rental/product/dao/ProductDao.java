package com.seoyeon.rental.product.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public interface ProductDao {

	int insertProductMfp(SqlSessionTemplate sqlSession, Map<String, Object> param);

	int insertProductMfpAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap);

	int insertProductExpd(SqlSessionTemplate sqlSession, Map<String, Object> param);

	int insertProductExpdAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap);

	List<Map<String, Object>> selectProductMfpList(SqlSessionTemplate sqlSession);

	List<Map<String, Object>> selectProductExpdList(SqlSessionTemplate sqlSession);

	int selectProductMfpListCount(SqlSessionTemplate sqlSession);

	int selectProductExpdListCount(SqlSessionTemplate sqlSession);

	Map<String, Object> selectProductMfpDetail(SqlSessionTemplate sqlSession, String prodId);

	Map<String, Object> selectProductExpdDetail(SqlSessionTemplate sqlSession, String prodId);

	int deleteProductMfp(SqlSessionTemplate sqlSession, String prodId);

	int deleteProductExpd(SqlSessionTemplate sqlSession, String prodId);

	int deleteProductMfpAttachment(SqlSessionTemplate sqlSession, String prodId);

	int deleteProductExpdAttachment(SqlSessionTemplate sqlSession, String prodId);

	int updateProductMfpAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap);

	int updateProductMfp(SqlSessionTemplate sqlSession, Map<String, Object> param);

	int updateProductExpdAttachment(SqlSessionTemplate sqlSession, Map<String, Object> attMap);

	int updateProductExpd(SqlSessionTemplate sqlSession, Map<String, Object> param);

}