package com.bitacademy.helloweb.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	public void a() {
	}

	@RequestMapping("/hello") // "/helloweb/~" 아님!
	public String hello() {
		return "/WEB-INF/views/hello.jsp"; // forward 직접하지 않음!
	}

	@RequestMapping("/hello2") // "/helloweb/~" 아님!
	public String hello2(String name) {
		System.out.println("name : " + name);
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}

	@RequestMapping("/hello4") // 추천 결과는 hello3과 동일
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello4.jsp";

	}

	@ResponseBody // 직접 body 내용을 붙임
	@RequestMapping("/hello5")
	public String hello5() {
		return "<h1>Hello World<h1>";

	}

	@RequestMapping("/hello6") // redirect
	public String hello6() {
		return "redirect:/hello";

	}

	@RequestMapping("/hello7") // 비추 코드!! 톰캣의 기술 사용하는것 좋지 않음
	public void hello7(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {

		String name = request.getParameter("name");
//		response.getWriter().println("hello "+name);
		out.write("hello " + name);
	}

}
