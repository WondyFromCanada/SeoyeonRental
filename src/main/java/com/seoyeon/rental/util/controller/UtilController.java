package com.seoyeon.rental.util.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.HomeController;

@Controller
public class UtilController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 로그아웃
	**/
	@GetMapping(value= "logout.do")
	public String logout(SessionStatus status, HttpSession session) {
		session.invalidate();
		status.setComplete();
		return "main/main";
	}
	
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

	/*
	 =========================================================
	 					<> 고객센터 영역 <>
	 =========================================================	
	 */
	
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
	 *  Discription : 고객센터 1:1문의 상세보기 페이지 이동
	**/
	@GetMapping(value = "customerQuestionDetailPage.do")
	public String customerQuestionDetailPage() {
		return "customer/questionBoard/questionBoardDetail";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 고객센터 자료실 페이지 이동
	**/
	@GetMapping(value = "customerMaterialBoardPage.do")
	public String customerMaterialBoardPage() {
		return "customer/materialBoard/materialBoardMain";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 고객센터 자료실 상세보기 페이지 이동
	**/
	@GetMapping(value = "customerMaterialDetailPage.do")
	public String customerMaterialDetailPage() {
		return "customer/materialBoard/materialBoardDetail";
	}
	
	
	/*
	 =========================================================
	 					<> 관리자 영역 <>
	 =========================================================	
	 */
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 5.
	 * Discription : 관리자 메인페이지로 이동
	**/
	@GetMapping(value = "adminMainPage.do")
	public String adminMainPage() {
		return "admin/main/adminMain";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 5.
	 * Discription : 관리자 렌탈제품관리 페이지로 이동
	**/
	@GetMapping(value = "rentalProdMgmtPage.do")
	public String rentalProdMgmtPage() {
		return "admin/product/rental/adminRentalProdMgmtMain";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 5.
	 * Discription : 관리자 판매제품관리 페이지로 이동
	**/
	@GetMapping(value = "sellProdMgmtPage.do")
	public String sellProdMgmtPage() {
		return "admin/product/sell/adminSellProdMgmtMain";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 관리자 자료실 등록 페이지
	**/
	@GetMapping(value = "customerMaterialEnrollPage.do")
	public String adminCustomerMaterialEnrollPage() {
		return "admin/customer/materialBoard/adminMaterialEnroll";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 5.
	 * Discription : 관리자 판매 제품 등록 페이지로 이동
	**/
	@GetMapping(value = "sellProductEnrollPage.do")
	public String adminSellProductEnrollPage() {
		return "admin/product/sell/adminSellProdEnroll";
	}


}
