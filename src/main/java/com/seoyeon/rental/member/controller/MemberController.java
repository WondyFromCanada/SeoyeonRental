package com.seoyeon.rental.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.member.service.MemberService;

@RestController
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 *	Author : dhkim
	 *	Date : 2020. 3. 3.
	 *  Discription : 회원가입 메소드 
	**/
	
	@Transactional
	@PostMapping(value = "/member")
	public Map<String, Object> insertMember(@RequestBody Map<String, Object> map) {
		String encPassword = passwordEncoder.encode(map.get("userPwd") + "");
		map.put("userPwd", encPassword);
		int result = ms.insertMember(map);
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		if( result > 0 ) resultMap.put("result", "success");
		else resultMap.put("result", "fail");

		return resultMap;
	}
	
	
	/**
	 *	Author : 김동환
	 *	Date : 2020. 3. 4.
	 *  Discription : 로그인
	**/
	@PostMapping(value = "/member/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> map, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		try {
			//로그인 체크 기능은 service단에서 구현
			Map<String, Object> loginUserInf = ms.login(map);
			session.setAttribute("loginUser", loginUserInf);
			resultMap.put("result", "success");
		} catch(Exception e) {
			e.printStackTrace();
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
}
