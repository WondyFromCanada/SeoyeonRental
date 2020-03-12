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

}
