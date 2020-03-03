package com.seoyeon.rental.util.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilController {

	@GetMapping(value = "login.do")
	public String login() {
		
		return null;
	}
	
	
	@GetMapping(value = "joinPage.do")
	public String joinPage() { 
		return "member/memberJoin";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 3.
	 *  Discription : 고객센터 1:1문의 페이지 이동
	**/
	@GetMapping(value = "customerQuestionBoardPage.do")
	public String customerQuestionBoardPage() {
		return "customer/questionBoard/questionBoardMain";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 3.
	 *  Discription : 고객센터 1:1문의 등록 페이지 이동
	**/
	@GetMapping(value = "customerQuestionEnrollPage.do")
	public String customerQuestionEnrollPage() {
		return "customer/questionBoard/questionBoardEnroll";
	}
}
