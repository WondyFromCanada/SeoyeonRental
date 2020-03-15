/**
 * 
 */
package com.seoyeon.rental.productBoard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.productBoard.service.ProductBoardService;

/**
 * @author dhkim
 *
 */
@RestController
public class ProductBoardController {
	private static final Logger logger = LoggerFactory.getLogger(ProductBoardController.class);

	@Autowired
	private ProductBoardService pbs;
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 15.
	 *  Discription : ck Editor 이미지 업로드
	**/
	@PostMapping(value = "/productBoard/rental/expd/imgUpload")
	public String imageUpload(
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("upload") MultipartFile upload) throws Exception {
		pbs.imageUpload(request, response, upload);
		return null;
	}
	
	@PostMapping(value = "/productBoard/rental/mfp")
	public Map<String, Object> insertProductBoardRentalMfp(
			@RequestBody Map<String, Object> param) {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		int result = pbs.insertProductBoardRentalMfp(param);
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
}
