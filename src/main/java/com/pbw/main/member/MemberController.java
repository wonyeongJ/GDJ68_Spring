package com.pbw.main.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String getLogin() throws Exception{
		System.out.println("login");
		return "member/login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String getLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO=memberService.getLogin(memberDTO);
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("join")
	public String getJoin() throws Exception{
		System.out.println("Join");
		return "member/join";
	}
	
	@RequestMapping("mypage")
	public String getMypage() throws Exception{
		System.out.println("MyPage");
		return "member/mypage";
	}
	
	@RequestMapping("logout")
	public String getLogout(HttpSession session) throws Exception{
		System.out.println("logout");
		session.invalidate();
		return "Index";
	}
	
	
	
}
