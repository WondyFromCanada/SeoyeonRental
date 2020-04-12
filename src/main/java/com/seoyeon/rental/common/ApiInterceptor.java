package com.seoyeon.rental.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class ApiInterceptor extends HandlerInterceptorAdapter{

	//list를 static 으로 만들어 줌으로서 apiInterceptor 탈때 매번
	//생성하는 것이 아닌 최초 한번만 생성(최적화)
	private static List<String> loginChkApiList;
	
	private static final Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);
	
	public ApiInterceptor () {
		//spring container에 올라가는 처음에만 리스트 생성
		loginChkApiList = new ArrayList<String> ();
		
		//로그인 체크 필요한 api 주소를담음
		//추후에는 ini파일에 넣어서 관리할 예정
		loginChkApiList.add("/rental/customer/faq");
		loginChkApiList.add("/rental/customer/question");
		loginChkApiList.add("/rental/install");
	}
	
	//controller 진입 전에 실행
	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getLocalAddr() + ":" + request.getLocalPort() + request.getRequestURI().toString();
		String method = request.getMethod();
		System.out.println("============================================================ " + requestURI + " ============================================================\r\n");
		System.out.println("◆ HTTP 메소드 : " + method);
		
		boolean chkFlag = true;
		//등록, 수정, 삭제인 경우만 체크
		if( method.equals("POST") || 
			method.equals("PUT") || 
			method.equals("DELETE")) {
			
			//전체 리스트를 뒤져서 api가 해당하는지 체크
			for(int i = 0; i < loginChkApiList.size(); i++) {
				if( loginChkApiList.get(i).equals(request.getRequestURI().toString()) ) {
					System.out.println("체크 대상 API!");
					//체크 대상인 경우 session체크
					if(request.getSession().getAttribute("loginUser") == null) {
						System.out.println("session 만료!");
						chkFlag = false;
						
						//break: 체크완료되었으면 리스트를
						//끝까지 돌지 않고 빠져나옴(최적화)
						break;
					}
					
				}
			}
		
			
		}
		
		return chkFlag;
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
