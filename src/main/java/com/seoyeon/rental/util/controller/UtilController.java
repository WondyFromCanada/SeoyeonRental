package com.seoyeon.rental.util.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilController {

	@GetMapping(value = "login.do")
	public String login() {
		
		return null;
	}
	
	
	@GetMapping(value = "joinPage.do")
	public String joinPage() { 
		return "member/memberJoin";
	}
}
