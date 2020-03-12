package com.seoyeon.rental.util.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.customer.service.CustomerMaterialService;
import com.seoyeon.rental.product.service.ProductService;

@Controller
public class UtilController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private CustomerMaterialService cms;
	
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
		return "redirect:mainPage.do";
	}
	
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
	 * Author : 김동환 
	 * Date : 2020. 3. 3. 
	 * Discription : 고객센터 페이지 (1:1 문의) 이동
	 **/
	@GetMapping(value = "customerQuestionBoardPage.do")
	public String customerQuestionBoardPage() {
		return "customer/questionBoard/questionBoardMain";
	}
	
	/* TopNav End */
	
	/* 고객센터 Start */	
	
	/**
	 * Author : 김동환 
	 * Date : 2020. 3. 3. 
	 * Discription : 고객센터 1:1문의 등록 페이지 이동
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
	 *	Date : 2020. 3. 11.
	 *  Discription : 고객센터 faq 메인 페이지로 이동
	**/
	@GetMapping(value = "customerFaqBoardPage.do")
	public String customerFaqBoardPage() {
		return "customer/faqBoard/faqBoardMain";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 고객센터 faq 상세 페이지로 이동 
	**/
	@GetMapping(value="customerFaqDetailPage.do")
	public String customerFaqDetailPage() {
		return "customer/faqBoard/faqBoardDetail";
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
	/* 관리자 설치소식 Start*/
	
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
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 관리자 설치소식 상세 페이지로 이동
	**/
	@GetMapping(value = "adminInstallBoardMgmtDetailPage.do") 
	public String adminInstallBoardMgmtDetailPage() {
		return "admin/installBoard/adminInstallBoardMgmtDetail";
	}
		
	
	
	/* 관리자 설치소식 End*/
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 7.
	 * Discription : 관리자 고객센터 페이지 (1:1 문의)로 이동
	 **/
	@GetMapping(value = "adminCustomerQuestionBoardMgmtPage.do")
	public String adminCustomerQuestionBoardMgmtPage() {
		return "admin/customer/questionBoard/adminCustomerQuestionBoardMgmt";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 관리자 고객센터 1:1 문의 상세 페이지로 이동 
	**/
	@GetMapping(value = "adminCustomerQuestionBoardMgmtDetailPage.do")
	public String adminCustomerQuestionBoardMgmtDetailPage() {
		return "admin/customer/questionBoard/adminCustomerQuestionBoardMgmtDetail";
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
	 *	Date : 2020. 3. 5.
	 *  Discription : 관리자 자료실 등록 페이지로 이동
	 **/
	@GetMapping(value = "adminCustomerMaterialBoardMgmtEnrollPage.do")
	public String adminCustomerMaterialBoardEnrollPage() {
		return "admin/customer/materialBoard/adminCustomerMaterialBoardMgmtEnroll";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 관리자 자료실 상세 페이지로 이동 
	 **/
	@GetMapping(value= "adminCustomerMaterialBoardMgmtDetailPage.do")
	public String adminCustomerMaterialBoardMgmtDetailPage() {
		return "admin/customer/materialBoard/adminCustomerMaterialBoardMgmtDetail";
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
	
		/* 고객센터 End */
	
	/*
	 =========================================================
	 					<> 공통 영역 <>
	 =========================================================	
	 */
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : ck Editor 공통 등록 페이지
	**/
	@GetMapping(value = "ckEnrollPage.do")
	public String ckEnrollPage() {
		return "common/ckEnroll";
	}
	
	/*
	 =========================================================
	 					<> 파일 등록 영역 <>
	 =========================================================	
	 */
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 10.
	 * Discription : 제품관리 > 제품등록 (복합기)
	 **/
	@Transactional
	@PostMapping(value= "adminProdMfpMgmtEnroll.do")
	public String insertProductMfp(
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(name = "prodMfpImg", required = false) MultipartFile prodMfpImg, 
			@RequestParam(name = "mfpBrandInf") String mfpBrandInf, @RequestParam(name = "mfpProdNm") String mfpProdNm,
			@RequestParam(name = "outputSpd") int outputSpd, @RequestParam(name = "scanSpd") int scanSpd,
			@RequestParam(name = "mfpProdInf") String mfpProdInf, @RequestParam(name = "networkDivsn") String networkDivsn,
			@RequestParam(name = "paperDivsn") String paperDivsn, @RequestParam(name = "colorYn") String colorYn) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
			//form으로 받아온 파라미터 처리
			String output = outputSpd + "매";
			String scan = scanSpd + "매";
			String color = "";
			if (colorYn.equals("흑백")) color = "N";
			else color = "Y";
			
			//디비로 보낼 파라미터, file데이터, request객체 service로 전송
			Map<String, Object> param = new HashMap<String, Object> ();
			param.put("mfpBrandInf", mfpBrandInf);
			param.put("mfpProdInf", mfpProdInf);
			param.put("mfpProdNm", mfpProdNm);
			param.put("output", output);
			param.put("scan", scan);
			param.put("networkDivsn", networkDivsn);
			param.put("paperDivsn", paperDivsn);
			param.put("color", color);
			
			int result = ps.insertProductMfp(param, prodMfpImg, request);
			
			if( result > 0 ) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "fail");
			}
			
		return "redirect:adminProdMfpMgmtPage.do";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 10.
	 * Discription : 제품관리 > 제품등록 (소모품)
	 **/
	@Transactional
	@PostMapping(value= "adminProdExpdMgmtEnroll.do")
	public String insertProductExpd(
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(name = "prodExpdImg", required = false) MultipartFile prodExpdImg, 
			@RequestParam(name = "expdBrandInf") String expdBrandInf,
			@RequestParam(name = "expdProdNm") String expdProdNm,
			@RequestParam(name = "expdProdInf") String expdProdInf,
			@RequestParam(name = "sellYn") String sellYn,
			@RequestParam(name = "expdModelAvail") String expdModelAvail) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
			//form으로 받아온 파라미터 처리
			String sell = "";
			if (sellYn.equals("가능")) sell = "Y";
			else sell = "N";
			
			//디비로 보낼 파라미터, file데이터, request객체 service로 전송
			Map<String, Object> param = new HashMap<String, Object> ();
			param.put("expdBrandInf", expdBrandInf);
			param.put("expdProdNm", expdProdNm);
			param.put("expdProdInf", expdProdInf);
			param.put("expdModelAvail", expdModelAvail);
			param.put("sell", sell);
			
			int result = ps.insertProductExpd(param, prodExpdImg, request);
			
			if( result > 0 ) {
				resultMap.put("result", "success");
			} else {
				resultMap.put("result", "fail");
			}
			
		return "redirect:adminProdExpdMgmtPage.do";
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 고객센터 자료실 게시글 업로드
	**/
	//mysql은 @transcational이 잘 안먹는거 같음
	@Transactional(rollbackFor={Exception.class})
	@PostMapping(value= "adminCustomerMaterialMgmtEnroll.do")
	public String insertCustomerMaterialBoard(
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(name = "file", required = false) MultipartFile file, 
			@RequestParam(name = "title") String title, 
			@RequestParam(name = "content") String content) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
			//디비로 보낼 파라미터, file데이터, request객체 service로 전송
			Map<String, Object> param = new HashMap<String, Object> ();
			param.put("title", title);
			param.put("content", content);
			int result = cms.insertCustomerMaterialBoard(param, file, request);
			
			if( result > 0 ) {
				return "redirect:adminCustomerMaterialBoardMgmtPage.do"; 
			} else {
				return "common/errorPage";
			}
		}
	
}
