/**
 * 
 */
package com.seoyeon.rental.customer.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author dhkim
 *
 */
public interface CustomerFaqService {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	 * @throws Exception 
	**/
	void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) throws Exception;

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	**/
	int insertCustomerFaqBoard(Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	**/
	List<Map<String, Object>> selectCustomerFaqBoardList();

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	**/
	Map<String, Object> selectCustomerFaqBoard(String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 9.
	 *  Discription : 
	**/
	int updateCustomerFaqBoard(Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 10.
	 *  Discription : 
	**/
	int deleteCustomerFaqBoard(String postId);

}
