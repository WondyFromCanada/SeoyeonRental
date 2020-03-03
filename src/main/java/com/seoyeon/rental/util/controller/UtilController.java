package com.seoyeon.rental.util.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilController {

	/**
	 * Author : 김정언
	 * Date : 2020. 3. 3.
	 * Discription : 메인 페이지로 이동
	 **/
	@GetMapping(value = "mainPage.do")
	public String mainPage() { 
		return "main/main";
	}
	
	/**
	 * Author : 김동환
	 * Date : 2020. 3. 2.
	 * Discription : 로그인
	**/
	@GetMapping(value = "login.do")
	public String login() {		
		return null;
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 3.
	 * Discription : 로그인 페이지로 이동
	**/
	@GetMapping(value = "loginPage.do")
	public String loginPage() {		
		return "member/memberLogin";
	}
	
	/**
	 * Author : 김동환
	 * Date : 2020. 3. 3.
	 * Discription : 회원가입 페이지로 이동
	**/
	@GetMapping(value = "joinPage.do")
	public String joinPage() { 
		return "member/memberJoin";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 3.
	 * Discription : 마이페이지로 이동
	**/
	@GetMapping(value = "myPage.do")
	public String myPage() { 
		return "member/myPage";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 3.
	 * Discription : 복합기렌탈 페이지로 이동
	**/
	@GetMapping(value = "mfpRentalPage.do")
	public String mfpRentalPage() { 
		return "product/mfp/mfpRentalMain";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 3.
	 * Discription : 복합기판매 페이지로 이동
	**/
	@GetMapping(value = "mfpSellPage.do")
	public String mfpSellPage() { 
		return "product/mfp/mfpSellMain";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 3.
	 * Discription : 소모품판매 페이지로 이동
	**/
	@GetMapping(value = "expdSellPage.do")
	public String expdSellPage() { 
		return "product/expd/expdSellMain";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 3.
	 * Discription : 설치소식 페이지로 이동
	**/
	@GetMapping(value = "installBoardPage.do")
	public String installBoardPage() { 
		return "installBoard/installBoardMain";
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
