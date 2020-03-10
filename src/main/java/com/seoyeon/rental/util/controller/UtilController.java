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

	/*
	 =========================================================
	 					<> 사용자 영역 <>
	 =========================================================	
	 */
	
	/* TopNav Start */
	
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
	
	/**
	 * Author : 김동환 Date : 2020. 3. 3. Discription : 고객센터 페이지 (1:1 문의) 이동
	 **/
	@GetMapping(value = "customerQuestionBoardPage.do")
	public String customerQuestionBoardPage() {
		return "customer/questionBoard/questionBoardMain";
	}

	/* TopNav End */
	
	/* 고객센터 Start */	

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
	
	/* 고객센터 End */
	
	
	/*
	 =========================================================
	 					<> 관리자 영역 <>
	 =========================================================	
	 */
	
	/* TopNav Start */
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 5.
	 * Discription : 관리자 메인페이지 (견적문의)로 이동
	**/
	@GetMapping(value = "adminEstimateMgmtPage.do")
	public String adminMainPage() {
		return "admin/estimate/adminEstimateMgmt";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 5.
	 * Discription : 관리자 회원관리 페이지로 이동
	**/
	@GetMapping(value = "adminMemberMgmtPage.do")
	public String adminMemberMgmtPage() {
		return "admin/member/adminMemberMgmt";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 5.
	 * Discription : 관리자 제품관리 페이지로 이동
	**/
	@GetMapping(value = "adminProdMfpMgmtPage.do")
	public String adminProdMfpMgmtPage() {
		return "admin/productMgmt/mfp/adminProdMfpMgmt";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 7.
	 * Discription : 관리자 제품게시판 페이지로 이동
	**/
	@GetMapping(value = "adminProdMfpRentalBoardMgmtPage.do")
	public String adminProdMfpRentalBoardMgmtPage() {
		return "admin/productBoardMgmt/mfpRental/adminProdMfpRentalBoardMgmt";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 7.
	 * Discription : 관리자 설치소식 페이지로 이동
	**/
	@GetMapping(value = "adminInstallBoardMgmtPage.do")
	public String adminInstallBoardMgmtPage() {
		return "admin/installBoard/adminInstallBoardMgmt";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 7.
	 * Discription : 관리자 고객센터 페이지 (1:1 문의)로 이동
	**/
	@GetMapping(value = "adminCustomerQuestionBoardMgmtPage.do")
	public String adminCustomerQuestionBoardMgmtPage() {
		return "admin/customer/questionBoard/adminCustomerQuestionBoardMgmt";
	}
	
	/* TopNav End */
	
	/* 제품관리 Start */
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 5.
	 * Discription : 관리자 복합기 제품등록 페이지로 이동
	**/
	@GetMapping(value = "adminProdMfpMgmtEnrollPage.do")
	public String adminProdMfpMgmtEnrollPage() {
		return "admin/productMgmt/mfp/adminProdMfpMgmtEnroll";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 9.
	 * Discription : 관리자 소모품 페이지로 이동
	**/
	@GetMapping(value = "adminProdExpdMgmtPage.do")
	public String adminProdExpdMgmtPage() {
		return "admin/productMgmt/expd/adminProdExpdMgmt";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 7.
	 * Discription : 관리자 소모품 제품등록 페이지로 이동
	**/
	@GetMapping(value = "adminProdExpdMgmtEnrollPage.do")
	public String adminProdExpdMgmtEnrollPage() {
		return "admin/productMgmt/expd/adminProdExpdMgmtEnroll";
	}
	
	/* 제품관리 End */
	
	/* 고객센터 Start */
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 관리자 고객센터 자료실 메인 페이지로 이동
	**/
	@GetMapping(value = "adminCustomerMaterialBoardMgmtPage.do")
	public String adminCustomerMaterialBoardMgmtPage() {
		return "admin/customer/materialBoard/adminCustomerMaterialBoardMgmt";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 관리자 고객센터 faq 메인 페이지로 이동
	**/
	@GetMapping(value = "adminCustomerFaqBoardMgmtPage.do")
	public String adminCustomerFaqBoardMgmtPage() {
		return "admin/customer/faqBoard/adminCustomerFaqBoardMgmt";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 7.
	 *  Discription : 고객센터 faq 등록 페이지로 이동
	 **/
	@GetMapping(value = "adminCustomerFaqBoardEnrollPage.do")
	public String adminCustomerFaqEnrollPage() {
		return "admin/customer/faqBoard/adminCustomerFaqBoardMgmtEnroll";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 고객센터 faq 상세 페이지로 이동
	**/
	@GetMapping(value = "adminCustomerFaqBoardMgmtDetailPage.do")
	public String adminCustomerFaqBoardMgmtDetailPage() {
		return "admin/customer/faqBoard/adminCustomerFaqBoardMgmtDetail";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 관리자 자료실 등록 페이지로 이동
	 **/
	@GetMapping(value = "adminCustomerMaterialEnrollPage.do")
	public String adminCustomerMaterialEnrollPage() {
		return "admin/customer/materialBoard/adminCustomerMaterialMgmtEnroll";
	}
	

	/* 고객센터 End */
}
