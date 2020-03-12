package com.seoyeon.rental.installBoard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.installBoard.service.InstallBoardService;

@RestController
public class InstallBoardController {

	@Autowired
	private InstallBoardService ibs;
	
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 설치소식 ck Editor 파일 업로드
	**/
	@PostMapping(value = "/install/imgUpload")
	public String imageUpload(
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("upload") MultipartFile upload) throws Exception {
		ibs.imageUpload(request, response, upload);
		return null;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 11.
	 *  Discription : 설치소식 게시글 등록 
	**/
	@PostMapping(value = "/install")
	public Map<String, Object> insertInstallBoard(@RequestBody Map<String, Object> param) {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		int result = ibs.insertInstallBoard(param);
		
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
	
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 설치소식 전체 게시글 조회
	**/
	@GetMapping(value = "/install")
	public List<Map<String, Object>> selectInstallBoardList() {
		return ibs.selectInstallBoardList();
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 설치소식 상세 게시글 조회
	**/
	@GetMapping(value = "/install/{postId}")
	public Map<String, Object> selectInstallBoard(@PathVariable String postId) {
		return ibs.selectInstallBoard(postId);
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 설치소식 게시글 삭제
	**/
	@DeleteMapping(value = "/install/{postId}")
	public Map<String, Object> deleteInstallBoard(@PathVariable String postId) {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		int result = ibs.deleteInstallBoard(postId);
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 12.
	 *  Discription : 설치소식 게시글 수정
	**/
	@PutMapping(value = "/install/{postId}")
	public Map<String, Object> updateInstallBoard(@PathVariable String postId, @RequestBody Map<String, Object> param) {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		int result = ibs.updateInstallBoard(param);
		if(result > 0) resultMap.put("result", "success");
		else resultMap.put("result", "fail");
		return resultMap;
	}
	
}
