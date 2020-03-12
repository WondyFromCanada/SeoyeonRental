/**
 * 
 */
package com.seoyeon.rental.installBoard.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author dhkim
 *
 */
public interface InstallBoardService {

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 
	 * @throws IOException 
	**/
	void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) throws IOException ;

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 
	**/
	int insertInstallBoard(Map<String, Object> param);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 
	**/
	List<Map<String, Object>> selectInstallBoardList();

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 
	**/
	Map<String, Object> selectInstallBoard(String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 
	**/
	int deleteInstallBoard(String postId);

	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 
	**/
	int updateInstallBoard(Map<String, Object> param);

}
