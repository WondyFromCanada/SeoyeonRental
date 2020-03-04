package com.seoyeon.rental.util.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seoyeon.rental.HomeController;

@Controller
public class UtilController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Author : 김정언 Date : 2020. 3. 3. Discription : 메인 페이지로 이동
	 **/
	@GetMapping(value = "mainPage.do")
	public String mainPage() {
		return "main/main";
	}

	/**
	 * Author : 김정언 Date : 2020. 3. 3. Discription : 로그인 페이지로 이동
	 **/
	@GetMapping(value = "loginPage.do")
	public String loginPage() {
		return "member/memberLogin";
	}

	/**
	 * Author : 김동환 Date : 2020. 3. 3. Discription : 회원가입 페이지로 이동
	 **/
	@GetMapping(value = "joinPage.do")
	public String joinPage() {
		return "member/memberJoin";
	}

	/**
	 * Author : 김정언 Date : 2020. 3. 3. Discription : 마이페이지로 이동
	 **/
	@GetMapping(value = "myPage.do")
	public String myPage() {
		return "member/myPage";
	}

	/**
	 * Author : 김정언 Date : 2020. 3. 3. Discription : 복합기렌탈 페이지로 이동
	 **/
	@GetMapping(value = "mfpRentalPage.do")
	public String mfpRentalPage() {
		return "product/mfp/mfpRentalMain";
	}

	/**
	 * Author : 김정언 Date : 2020. 3. 3. Discription : 복합기판매 페이지로 이동
	 **/
	@GetMapping(value = "mfpSellPage.do")
	public String mfpSellPage() {
		return "product/mfp/mfpSellMain";
	}

	/**
	 * Author : 김정언 Date : 2020. 3. 3. Discription : 소모품판매 페이지로 이동
	 **/
	@GetMapping(value = "expdSellPage.do")
	public String expdSellPage() {
		return "product/expd/expdSellMain";
	}

	/**
	 * Author : 김정언 Date : 2020. 3. 3. Discription : 설치소식 페이지로 이동
	 **/
	@GetMapping(value = "installBoardPage.do")
	public String installBoardPage() {
		return "installBoard/installBoardMain";
	}

	/**
	 * Author : 김동환 Date : 2020. 3. 3. Discription : 고객센터 1:1문의 페이지 이동
	 **/
	@GetMapping(value = "customerQuestionBoardPage.do")
	public String customerQuestionBoardPage() {
		return "customer/questionBoard/questionBoardMain";
	}

	/**
	 * Author : 김동환 Date : 2020. 3. 3. Discription : 고객센터 1:1문의 등록 페이지 이동
	 **/
	@GetMapping(value = "customerQuestionEnrollPage.do")
	public String customerQuestionEnrollPage() {
		return "customer/questionBoard/questionBoardEnroll";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 고객센터 1:1문의 상세보기
	**/
	@GetMapping(value = "customerQuestionDetailPage.do")
	public String customerQuestionDetailPage() {
		return "customer/questionBoard/questionBoardDetail";
	}

}
