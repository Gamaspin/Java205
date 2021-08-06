package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.LoginInfo;
import com.bitcamp.firstSpring.member.domain.LoginRequest;

@Controller
@RequestMapping("/member/login")	// <<- 브라우저에서 사용하는 URL을 뜻함(context 경로 뒤쪽으로 들어오는 경로) : http://localhost:8080/mvc'
public class LoginController {

	// @RequestMapping("/member/loginform")
	//@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(
			//@RequestParam(value="page", required= true) String page
			@RequestParam(value="page", defaultValue="1") String page
			) { // error 400이면 보통 이쪽에서 문제일 확률이 큼 (일단 true가 기본값)
		//System.out.println(page+1);
		// required=false했을 때 int page 하면 null을 int로 바꾸지 못해 error500 뜸
		// 유효성 검사 때문에 웬만하면 String으로 받고 그 밑에서 int로 변환해주는게 더 나음
		System.out.println(page);
		return "member/loginForm"; // /WEB-INF/views/member/loginForm.jsp
	}								// jsp의 경로. 이를 이용해서 view 페이지 정보를 반환함

	//  /member/login/member/login
	//@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			@RequestParam("id") String id, 
			@RequestParam("pw") String pw,
			HttpServletRequest request,
			@ModelAttribute("loginReq") LoginRequest loginRequest,
			Model model
			
			) {
		
		// 사용자의 파라미터 데이터를 받는 방법
		// 1. HttpServletRequest 이용
		// 2. @RequestParam("param name")
		// 3. 커맨드 객체(Beans) 이용
		
				
		System.out.println("id" + id + ", pw :" + pw);
		
		
		// view에 전달할 데이터 저장 : Model 객체를 이용
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
	
		
		
		
		
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		
		System.out.println("uid" + uid + ", upw :" + upw);
	
		model.addAttribute("uid", uid);
		model.addAttribute("upw", upw);
	
		
		
		System.out.println(loginRequest);
		
		// 세션의 속성에 loginInfo 등록
				request.getSession(false).setAttribute("loginInfo", new LoginInfo());
				
		return "member/login"; // /WEB-INF/views/member/login.jsp
	}

}