package com.seoyeon.rental.customer.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 *	Date : 2020. 3. 5.
	 *  Discription : 고객센터 자료실 게시글 업로드
	**/
	//mysql은 @transcational이 잘 안먹는거 같음
	@Transactional
	@PostMapping(value= "/customer/material")
	public String insertCustomerMaterialBoard(
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(name = "file", required = false) MultipartFile file, 
			@RequestParam(name = "title") String title, 
			@RequestParam(name = "content") String content) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		if(session.getAttribute("loginUser") == null) {
			resultMap.put("result", "loginRequired");
			return "common/errorPage";
		} else {
			//디비로 보낼 파라미터, file데이터, request객체 service로 전송
			Map<String, Object> param = new HashMap<String, Object> ();
			param.put("title", title);
			param.put("content", content);
			int result = cms.insertCustomerMaterialBoard(param, file, request);
			
			if( result > 0 ) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "fail");
			}
			
		}
		return "admin/customer/materialBoard/adminMaterialMain";
	}
}
