package com.bitacademy.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequestMapping 클래스 단독 맵핑
 *
 */

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody	
	@RequestMapping // 핸들러 표시는 해줘야함 메소드 이름이 url이 된다 /helloweb03/guestbook/list
	public String list() {
		return "GuestbookController.list()";
	}
	
	@ResponseBody	
	@RequestMapping // 핸들러 표시는 해줘야함 메소드 이름이 url이 된다 /helloweb03/guestbook/delete
	public String delete() {
		return "GuestbookController.delete()";
	}
}
