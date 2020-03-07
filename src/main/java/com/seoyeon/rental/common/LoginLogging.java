package com.seoyeon.rental.common;

import java.util.Date;

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
		System.out.println("login ReturnObject : " + returnObj);
		
//		if(returnObj instanceof Member) {
//			Member m = (Member) returnObj;
//			
//			//유저아이디 스플릿할 수 있도록 $ 사용
//			logger.info(new Date() + " : $" + m.getUserId() + "$님이 접속했습니다.");
//		}
	}
}
