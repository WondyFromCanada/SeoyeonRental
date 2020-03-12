package com.seoyeon.rental.customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.customer.service.CustomerMaterialService;

@Controller
public class CustomerMaterialController {

private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CustomerMaterialService cms;
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 10.
	 *  Discription : 고객센터 자료실 게시글 전체 조회
	**/
	@ResponseBody
	@GetMapping(value="/customer/material")
	public List<Map<String, Object>> selectCustomerMaterialBoardList() {
		List<Map<String, Object>> list = cms.selectCustomerMaterialBoardList();
		return list;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 10.
	 *  Discription : 고객센터 자료실 게시글 상세 조회
	**/
	@ResponseBody
	@GetMapping(value="/customer/material/{postId}")
	public Map<String, Object> selectCustomerMaterialBoard(@PathVariable String postId) {
		return cms.selectCustomerMaterialBoard(postId);
	}
}
