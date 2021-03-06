package com.seoyeon.rental.common;

import java.util.Date;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoginLogging {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogging.class);
	
	@Pointcut("execution(* com.seoyeon.rental..*ServiceImpl.*(..))")
	public void loginPointcut() {
		
	}
	
	@AfterReturning(pointcut="loginPointcut()", returning="returnObj")
	public void loginLog(JoinPoint jp, Object returnObj) {
		if(returnObj instanceof Map<?, ?>) {
			Map<String, Object> returnMap = (Map<String, Object>) returnObj;
			if(returnMap.get("loginFlag") != null && returnMap.get("loginFlag").equals("true")) {
				logger.info(new Date()  + " : " + returnMap.get("USER_NM") + "님이 접속했습니다.");
			}
		}
	}
}
