package com.bitacademy.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * !추천 
 * @RequestMapping 클래스 + 메소드 맵핑
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@ResponseBody
	@RequestMapping("") // @RequestMapping("/") 안됨 /helloweb03/user
	public String delete() {
		return "UserController.delete()";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET) // 하나의 url을 get/post 방식으로 나누어 관리
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST) // 하나의 url을 get/post 방식으로 나누어 관리
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping("/login") // /helloweb03/user/login
	public String login() {
		return "UserController.login()";
	}

//	@ResponseBody
//	@RequestMapping("/update")
//	public String update(String name) { // /helloweb03/user/update?name= 파라미터의 이름과 동일
//		return "UserController.update(" + name + ")";
//	}
	
//	@ResponseBody
//	@RequestMapping("/update")
//	public String update(@RequestParam("name") String name) { 
//	// /helloweb03/user/update?name= 파라미터의 이름과 동일해도 명시하는것이 좋음 변수이름은 의미있게! 파라미터는 변수이름과 다르게 간단하게 표시되는 경우 많음
//		return "UserController.update(" + name + ")";
//	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) { // /helloweb03/user/update?n=
		/**
		 * 만일 n이라는 이름의 URL 파라미터가 없는 경우 400 Bad Requst 에러가 발생한ㄷ가.
		 */
		return "UserController.update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2") // /helloweb03/user/update2
	public String update2(@RequestParam(value="n", required=true, defaultValue="") String name) { 
		return "UserController.update(" + name + ")";
	}	
	
	@ResponseBody
	@RequestMapping("/list") // /helloweb03/user/list
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int pageNo) { 
		return "UserController.list(" + pageNo + ")";
	}
}
