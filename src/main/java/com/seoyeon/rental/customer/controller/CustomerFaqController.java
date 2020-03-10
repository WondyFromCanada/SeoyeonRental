package com.seoyeon.rental.customer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.customer.service.CustomerFaqService;

@RestController
public class CustomerFaqController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerFaqController.class);
	
	@Autowired
	private CustomerFaqService cfs;
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 고객센터 faq ck Editor 파일 업로드
	**/
	@PostMapping(value = "/customer/faq/imgUpload")
	public String imageUpload(
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("upload") MultipartFile upload) throws Exception {
		cfs.imageUpload(request, response, upload);
		return null;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 고객센터 faq 문의 등록
	**/
	@PostMapping(value = "/customer/faq")
	public Map<String, Object> insertCustomerQuestionBoard(
			@RequestBody Map<String, Object> param, 
			HttpSession session) throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		
		if(session.getAttribute("loginUser") == null) {
			resultMap.put("result", "loginRequired");
			return resultMap;
		} else {
			@SuppressWarnings("unchecked")
			Map<String, Object> loginUserInf = (Map<String, Object>) session.getAttribute("loginUser");
			param.put("memberId", loginUserInf.get("MEMBER_ID") + "");
			
			int result = cfs.insertCustomerFaqBoard(param);
			if( result > 0 ) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "fail");
			}
			
		}
		
		return resultMap;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 고객센터 faq 전체 게시글 조회
	**/
	@GetMapping(value = "/customer/faq")
	public List<Map<String, Object>> selectCustomerFaqBoardList(HttpServletRequest request) {
		String userNm = "";
		if(request.getParameter("userNm") != null) {
			userNm = request.getParameter("userNm");
		}
		Map<String, Object> searchCondition = new HashMap<String, Object> ();
		searchCondition.put("userNm", userNm);		
		List<Map<String, Object>> list = cfs.selectCustomerFaqBoardList();
		return list;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 고객센터 faq 상세 게시글 조회
	**/
	@GetMapping(value = "/customer/faq/{postId}")
	public Map<String, Object> selectCustomerQuestionBoard(@PathVariable String postId, HttpSession session) {
		Map<String, Object> map = cfs.selectCustomerFaqBoard(postId);
		return map;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 고객센터 faq 게시글 수정
	**/
	@PutMapping(value = "/customer/faq/{postId}")
	public Map<String, Object> updateCustomerQuestionBoard(@PathVariable String postId, @RequestBody Map<String, Object> param) {
		int result = cfs.updateCustomerFaqBoard(param);
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
}
