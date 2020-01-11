package com.speshase.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler, ModelAndView mv) throws Exception {
		System.out.println("post handle.........."); //������ �� �ڿ� ���ͼ���
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler) throws Exception {
		System.out.println("pre handle.........."); //������ �� ���ͼ���
		return true;
		
	}
}
