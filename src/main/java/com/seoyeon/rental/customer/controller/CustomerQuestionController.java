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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.customer.service.CustomerQuestionService;

@RestController
public class CustomerQuestionController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CustomerQuestionService cqs;
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 고객센터 1:1 문의 ck Editor 파일 업로드
	**/
	@PostMapping(value="/customer/question/imgUpload")
	public String imageUpload(HttpServletRequest request, HttpServletResponse response, 
			 @RequestParam("upload") MultipartFile upload) throws Exception {
		cqs.imageUpload(request, response, upload);
		return null;
	}	
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 고객센터 1:1 문의 등록
	**/
	@PostMapping(value = "/customer/question")
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
			
			int result = cqs.insertCustomerQuestionBoard(param);
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
	 *	Date : 2020. 3. 4.
	 *  Discription : 고객센터 1:1문의 전체 게시글 조회
	**/
	@GetMapping(value = "/customer/question")
	public List<Map<String, Object>> selectCustomerQuestionBoardList(HttpServletRequest request) {
		String userNm = "";
		if(request.getParameter("userNm") != null) {
			userNm = request.getParameter("userNm");
		}
		Map<String, Object> searchCondition = new HashMap<String, Object> ();
		searchCondition.put("userNm", userNm);		
		List<Map<String, Object>> list = cqs.selectCustomerQuestionBoardList();
		return list;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 고객센터 1:1 문의 상세 게시글 조회
	**/
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/customer/question/{postId}")
	public Map<String, Object> selectCustomerQuestionBoard(@PathVariable String postId, HttpSession session) {
		
		Map<String, Object> map = cqs.selectCustomerQuestionBoard(postId);
		String postMid = map.get("MEMBER_ID") + "";
		String sessionId = ((Map<String, Object>)session.getAttribute("loginUser")).get("MEMBER_ID") + "";	
		
		Map<String, Object> falseMap = new HashMap<String, Object> ();
		falseMap.put("result", "unAuthorized");
		//로그인사용자와 작성자가 다른경우
		if( !postMid.equals(sessionId) ) {
			//관리자인 경우 
			if( (((Map<String, Object>)session.getAttribute("loginUser")).get("DIVSN") + "").equals("ADMIN") ) {
				return map;
			}
			return falseMap;
		}
		return map;
	
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 고객센터 1:1 문의 게시글 수정
	**/
	@PutMapping(value = "/customer/question/{postId}")
	public Map<String, Object> updateCustomerQuestionBoard(@PathVariable String postId, @RequestBody Map<String, Object> param) {
		int result = cqs.updateCustomerQuestionBoard(param);
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 고객센터 1:1 문의 게시글 삭제
	**/
	@DeleteMapping(value = "/customer/question/{postId}")
	public Map<String, Object> deleteCustomerQuestionBoard(@PathVariable String postId) {
		int result = cqs.deleteCustomerQuestionBoard(postId);
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
	
}
