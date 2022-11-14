package com.bitacademy.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello") //"/helloweb/~" 아님!
	public String hello() {
		return "/WEB-INF/views/hello.jsp"; //forward 직접하지 않음!
	}

}
