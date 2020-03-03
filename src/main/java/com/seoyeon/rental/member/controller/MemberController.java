package com.seoyeon.rental.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@PostMapping(value = "/member")
	public Map<String, Object> insertMember(@RequestBody Map<String, Object> map) {
		String encPassword = passwordEncoder.encode(map.get("userPwd") + "");
		map.put("userPwd", encPassword);
		
		Map<String, Object> resultMap = new HashMap<String, Object> ();
		int result = ms.insertMember(map);
		
		if( result > 0 ) resultMap.put("result", "success");
		else resultMap.put("result", "fail");

		return resultMap;
	}
}
