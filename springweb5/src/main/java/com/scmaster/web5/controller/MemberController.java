package com.scmaster.web5.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.scmaster.web5.dao.MemberDAO;
import com.scmaster.web5.vo.Member;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String joinForm(Model model) {
		Member member = new Member(	); // 추가
		model.addAttribute("member", member); // 추가
		return "customer/joinForm";
	}
	
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public String checkForm() {
		return "customer/idCheck";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute("member") Member member, Model model) {
		int result = dao.insert(member);
		if(result != 1) {
			return "customer/joinForm";
		} else {
			return "redirect:joinComplete";
		}
	}
	
	@RequestMapping(value="searchId", method=RequestMethod.POST)
	public String searchId(String id, Model model) {
		Member member = dao.searchId(id);
		if(member != null) {
			model.addAttribute("searchResult", member);
			model.addAttribute("search", true)	;
			model.addAttribute("id", member.getId());
		} else {
			model.addAttribute("searchId", id);
		}
		return "customer/idCheck";
	}
	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm() {
		
		return "customer/loginForm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(String id, String password, Model model, HttpSession session) {
		Member member = dao.login(id);
		if(member == null) {
			return "customer/loginForm";
		} else {
			if(member.getPassword().equals(password)) {
				session.setAttribute("id", member.getId());
				session.setAttribute("name", member.getName());
				session.setAttribute("member", member);
				return "redirect:/";
			} else {
				model.addAttribute("loginErr", "로그인 정보가 틀렸습니다.");
				return "customer/loginForm"; 
			}
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus sessionStatus) {
		session.invalidate();
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="joinComplete", method=RequestMethod.GET)
	public String joinComplete(Model model, @ModelAttribute("member") Member member, SessionStatus sessionStatus) {
		model.addAttribute("id", member.getId());
		return "customer/joinComplete";
	}
	
	@RequestMapping(value="updateForm", method=RequestMethod.GET)
	public String updateForm() {
		return "customer/updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute("member") Member member, HttpSession session) {
		int result = 0;
		try {
			
		} catch(Exception e) {
			result = dao.update(member);
		}
		if(result == 1) {
			session.setAttribute("member", member);
			return "redirect:/";
		} else {
			return "redirect:updateForm";
		}
	}
}
