package com.seoyeon.rental.product.controller;

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
import com.seoyeon.rental.product.service.ProductService;

@Controller
public class ProductAdminController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductService ps;
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 10.
	 * Discription : 제품관리 > 제품등록 (복합기)
	**/
	@Transactional
	@PostMapping(value= "/product/mfp")
	public String insertProductMfp(
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(name = "prodMfpImg", required = false) MultipartFile prodMfpImg, 
			@RequestParam(name = "mfpBrandInf") String mfpBrandInf, @RequestParam(name = "mfpProdNm") String mfpProdNm,
			@RequestParam(name = "outputSpd") int outputSpd, @RequestParam(name = "scanSpd") int scanSpd,
			@RequestParam(name = "mfpProdInf") String mfpProdInf, @RequestParam(name = "networkDivsn") String networkDivsn,
			@RequestParam(name = "paperDivsn") String paperDivsn, @RequestParam(name = "colorYn") String colorYn) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		if(session.getAttribute("loginUser") == null) {
			resultMap.put("result", "loginRequired");
			return "common/errorPage";
		} else {
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
			
		}
		return "admin/productMgmt/mfp/adminProdMfpMgmt";
	}
	
	/**
	 * Author : 김정언
	 * Date : 2020. 3. 10.
	 * Discription : 제품관리 > 제품등록 (소모품)
	**/
	@Transactional
	@PostMapping(value= "/product/expd")
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
		if(session.getAttribute("loginUser") == null) {
			resultMap.put("result", "loginRequired");
			return "common/errorPage";
		} else {
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
			
		}
		return "admin/productMgmt/expd/adminProdExpdMgmt";
	}
}
