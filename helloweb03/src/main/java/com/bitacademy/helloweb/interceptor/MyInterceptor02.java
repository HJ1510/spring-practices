package com.bitacademy.helloweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor02 extends HandlerInterceptorAdapter { //HandlerInterceptor 추천 HandlerInterceptorAdapter 비추

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("MyInterceptor02.preHandle()... called");
		return true; //false의 경우 handler는 작동하지만 뒤에 메소드 작동x
	}
	
	

}
