package com.bitacademy.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequestMapping 메소드 단독 맵핑
 *
 */

@Controller
public class BoardController {

	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
	}

	@ResponseBody
	@RequestMapping("/board/view")
	public String view(Long no) {
		return "BoardController.view(" + no + ")"; // helloweb03/board/view?no=10
	}

	@ResponseBody
	@RequestMapping("/board/view/{no}") // 추천
	public String view2(@PathVariable("no") Long no) {
		return "BoardController.view(" + no + ")"; // helloweb03/board/view/10
	}
	
	
}