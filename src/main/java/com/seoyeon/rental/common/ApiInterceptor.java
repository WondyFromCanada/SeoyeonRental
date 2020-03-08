package com.seoyeon.rental.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seoyeon.rental.exception.UserAuthException;


public class ApiInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);
	
	//controller 진입 전에 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//HttpSession session = request.getSession(false);
//		System.out.println("session : " + session);
		//logger.info("요청 주소 : [" + request.getMethod() + "] " + request.getLocalAddr() + ":" + request.getLocalPort() + request.getRequestURI().toString());
		String requestURI = request.getLocalAddr() + ":" + request.getLocalPort() + request.getRequestURI().toString();
		System.out.println("============================================================ " + requestURI + " ============================================================\r\n");
		System.out.println("◆ HTTP 메소드 : " + request.getMethod());
//		if( session.getAttribute("loginUser") != null ) {
//			throw new UserAuthException("권한이 없습니다", HttpStatus.UNAUTHORIZED);
//		}
		return true;
	}

	//view page 랜더링 직전에 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}


	//view page 랜더링 후에 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
	

}
