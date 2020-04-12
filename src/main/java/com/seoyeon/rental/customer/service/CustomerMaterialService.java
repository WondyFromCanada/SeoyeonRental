/**
 * 
 */
package com.seoyeon.rental.customer.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author dhkim
 *
 */
public interface CustomerMaterialService {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 5.
	 *  Discription : 
	 * @param file 
	 * @param request 
	**/
	int insertCustomerMaterialBoard(Map<String, Object> param, MultipartFile file, HttpServletRequest request) throws Exception;

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 10.
	 *  Discription : 
	**/
	List<Map<String, Object>> selectCustomerMaterialBoardList();

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 10.
	 *  Discription : 
	**/
	Map<String, Object> selectCustomerMaterialBoard(String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 15.
	 *  Discription : 
	**/
	List<Map<String, Object>> getGridColInf(Map<String, Object> param);

}
