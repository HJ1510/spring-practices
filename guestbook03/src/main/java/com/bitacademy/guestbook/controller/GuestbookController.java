package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.guestbook.repository.GuestbookRepository;
import com.bitacademy.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;

	@RequestMapping({ "/list", "" })
	public String index(Model model) {
		model.addAttribute("list", guestbookRepository.findAll());
		return "/WEB-INF/views/index.jsp";
	}

//	@RequestMapping({ "/list", "" })
//	public String index(Model model) {
//		List<GuestbookVo> list = guestbookRepository.findAll();
//		model.addAttribute("list", list);
//		return "/WEB-INF/views/index.jsp";
//	}
	
	@RequestMapping("/add")
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/delete.jsp";
	}
	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String delete() {
//		return "/WEB-INF/views/delete.jsp";
//	}
	
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String delete(
		@PathVariable("no") Long no,
		@RequestParam(value="password", required=true, defaultValue="") String password) {
//		System.out.println(no+"|"+password); 검토 미리 해볼것
		guestbookRepository.deleteByNoAndPassword(no, password);
		return "redirect:/";
	}	
	
	
	// @RequestParam(value="no", required=true, defaultValue="") 연구

}
