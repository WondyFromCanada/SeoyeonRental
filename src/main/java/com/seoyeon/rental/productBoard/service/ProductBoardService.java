/**
 * 
 */
package com.seoyeon.rental.productBoard.service;

import java.util.List;
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

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 16.
	 *  Discription : 
	**/
	List<Map<String, Object>> selectProductBoardRentalMfp();

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 16.
	 *  Discription : 
	**/
	Map<String, Object> selectProductBoardRentalMfpDetail(String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 16.
	 *  Discription : 
	**/
	int updateProductBoardRentalMfp(Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 16.
	 *  Discription : 
	**/
	int deleteProductBoardRentalMfp(Map<String, Object> param, HttpServletRequest request);

}
