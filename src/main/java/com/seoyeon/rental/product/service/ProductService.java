package com.seoyeon.rental.product.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

	int insertProductMfp(Map<String, Object> param, MultipartFile prodMfpImg, HttpServletRequest request) throws Exception;

	int insertProductExpd(Map<String, Object> param, MultipartFile prodExpdImg, HttpServletRequest request) throws Exception;

	List<Map<String, Object>> selectProductMfpList();

	List<Map<String, Object>> selectProductExpdList();

	int selectProductMfpListCount();

	int selectProductExpdListCount();

	Map<String, Object> selectProductMfpDetail(String prodId);

	Map<String, Object> selectProductExpdDetail(String prodId);

	int deleteProductMfp(HttpServletRequest request, String prodId);

	int deleteProductExpd(HttpServletRequest request, String prodId);

	int updateProductMfp(Map<String, Object> param, MultipartFile prodMfpImgDetail, HttpServletRequest request) throws Exception;

	int updateProductExpd(Map<String, Object> param, MultipartFile prodExpdImgDetail, HttpServletRequest request) throws Exception;

}
