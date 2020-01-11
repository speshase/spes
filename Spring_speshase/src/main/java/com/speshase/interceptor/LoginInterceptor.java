package com.speshase.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.speshase.controller.HomeController;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * preHandle:컨트롤러가 호출되기 전에 실행
	 * postHandle:컨트로러가 실행된 후에 실행
	 * afterComplete : 뷰에서 최종결과가생성하는 일을 포함한 모든 일이 완료되었을 때 싷행.
	 */
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("post handle.......... 실행"); //로그인 한 후
		
		HttpSession session = request.getSession();
		Object UserVO = modelAndView.getModel().get("userVO");
		System.out.println("interceptor postHandle = "+UserVO);

		if(UserVO != null) { // 사용자가 회원가입을 했으면,
		logger.info("New login success");
		session.setAttribute(LOGIN, UserVO); // 로그인 처리(session 회원정보 저장)
		response.sendRedirect("/spes"); // 로그인 성공 후 메인페이지로 이동.
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler) throws Exception {
		System.out.println("pre handle.......... 실행"); //로그인 하기 전
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) != null) { // 기존에 로그인이 되어있다면
			logger.info("Clear login data before");
			session.removeAttribute(LOGIN); //로그아웃. (로그인정보 삭제)
		}
		return true;
	}
}
