package com.bitacademy.hellspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringController {

	@RequestMapping("/hellospring")
	public String helloSpring(String num, Model model) {
		model.addAttribute("num", num);

		return ("/WEB-INF/views/hellospring.jsp");

	}

}
