/**
 * 
 */
package com.seoyeon.rental.customer.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.common.PageInfo;

/**
 * @author dhkim
 *
 */
public interface CustomerQuestionService {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	 * @throws IOException 
	**/
	void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) throws IOException;

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	 * @param session 
	 * @return 
	**/
	int insertCustomerQuestionBoard(Map<String, Object> param, HttpSession session);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	 * @param pi 
	**/
	List<Map<String, Object>> selectCustomerQuestionBoardList();

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 
	**/
	Map<String, Object> selectCustomerQuestionBoard(String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 
	**/
	int updateCustomerQuestionBoard(Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 
	**/
	int deleteCustomerQuestionBoard(String postId);

}
