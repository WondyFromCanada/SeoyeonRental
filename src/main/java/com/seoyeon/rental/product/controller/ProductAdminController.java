package com.seoyeon.rental.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.product.service.ProductService;

@Controller
public class ProductAdminController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductService ps;
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 11.
	 * Discription : 제품관리 (복합기) 전체 조회
	**/
	@ResponseBody
	@GetMapping(value="/product/mfp")
	public List<Map<String, Object>> selectProductMfpList() {
		List<Map<String, Object>> list = ps.selectProductMfpList();
		return list;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 11.
	 * Discription : 제품관리 (소모품) 전체 조회
	**/
	@ResponseBody
	@GetMapping(value="/product/expd")
	public List<Map<String, Object>> selectProductExpdList() {
		List<Map<String, Object>> list = ps.selectProductExpdList();
		return list;
	}
	
}
