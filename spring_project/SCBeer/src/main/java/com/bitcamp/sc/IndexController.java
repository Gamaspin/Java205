package com.bitcamp.sc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	

	
	
	@RequestMapping("/index")
	public void index() {
	}
	
	@RequestMapping("/index2")
	public void index2() {
	}

	
	@RequestMapping("/")
	public String index1() {
		System.out.println("/ 진입");
		return "redirect:/index";
	}

//	@RequestMapping("/WEB-INF/views/index.jsp")
//	public String index2() {
//		System.out.println("/ 진입2");
//		return "redirect:/index";
//	}
	
}