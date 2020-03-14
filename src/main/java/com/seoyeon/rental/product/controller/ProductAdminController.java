package com.seoyeon.rental.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.product.service.ProductService;

@RestController
public class ProductAdminController {

	private static final Logger logger = LoggerFactory.getLogger(ProductAdminController.class);
	
	@Autowired
	private ProductService ps;
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 11.
	 * Discription : 제품관리 복합기 전체 조회
	**/
	@GetMapping(value="/product/mfp")
	public List<Map<String, Object>> selectProductMfpList() {
		List<Map<String, Object>> list = ps.selectProductMfpList();
		return list;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 12.
	 * Discription : 제품관리 복합기 개수 전체 조회
	**/
	@GetMapping(value="/product/mfpCnt")
	public int selectProductMfpListCount() {
		int listCount = ps.selectProductMfpListCount();
		return listCount;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 11.
	 * Discription : 제품관리 소모품 전체 조회
	**/
	@GetMapping(value="/product/expd")
	public List<Map<String, Object>> selectProductExpdList() {
		List<Map<String, Object>> list = ps.selectProductExpdList();
		return list;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 12.
	 * Discription : 제품관리 소모품 전체 개수 조회
	**/
	@GetMapping(value="/product/expdCnt")
	public int selectProductExpdListCount() {
		int listCount = ps.selectProductExpdListCount();
		return listCount;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 13.
	 * Discription : 제품관리 복합기 상세 조회
	**/
	@GetMapping(value = "/product/mfp/{prodId}")
	public Map<String, Object> selectProductMfpDetail(@PathVariable String prodId, HttpSession session) {
		Map<String, Object> map = ps.selectProductMfpDetail(prodId);
		return map;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 13.
	 * Discription : 제품관리 소모품 상세 조회
	**/
	@GetMapping(value = "/product/expd/{prodId}")
	public Map<String, Object> selectProductExpdDetail(@PathVariable String prodId, HttpSession session) {
		Map<String, Object> map = ps.selectProductExpdDetail(prodId);
		return map;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 13.
	 * Discription : 제품관리 복합기 삭제
	**/
	@DeleteMapping(value = "/product/mfp/{prodId}")
	public Map<String, Object> deleteProductMfp(@PathVariable String prodId) {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		
		int result = ps.deleteProductMfp(prodId);
		
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 13.
	 * Discription : 제품관리 소모품 삭제
	**/
	@DeleteMapping(value = "/product/expd/{prodId}")
	public Map<String, Object> deleteProductExpd(@PathVariable String prodId) {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		
		int result = ps.deleteProductExpd(prodId);
		
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
}
