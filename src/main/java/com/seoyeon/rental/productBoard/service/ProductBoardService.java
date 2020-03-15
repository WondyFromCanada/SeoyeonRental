/**
 * 
 */
package com.seoyeon.rental.productBoard.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author dhkim
 *
 */
public interface ProductBoardService {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 15.
	 *  Discription : 
	 * @throws Exception 
	**/
	void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) throws Exception;

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 15.
	 *  Discription : 
	**/
	int insertProductBoardRentalMfp(Map<String, Object> param);

}
