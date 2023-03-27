package ezen.springmvc.web.controller.v4;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ezen.springmvc.domain.dto.Member;

@Controller // bean으로 등록하기 위해 무조건 등록
@RequestMapping("/springmvc/v4/members") //중복 URL이름 지정
public class MemberControllerV4 {
	
	@GetMapping("/register-form")
	public String registerForm(Model model) {
		model.addAttribute("", model);
		return "member/register-form";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam("name") String name, @RequestParam int age, Model model) {
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		// 서비스 객체를 이용한 회원 등록
		// memberService.registerMember(member);
		
		model.addAttribute("member", member);
		return "member/register-result";
	}
	
	//@RequestMapping
	@GetMapping
	public String members(Model model) {
		// 서비스 객체를 이용한 회원 목록
		// List<Member> members = memberService.getMembers();
		List<Member> members = new ArrayList<>();
		members.add(new Member("홍길동1", 10));
		members.add(new Member("홍길동2", 20));
		members.add(new Member("홍길동3", 30));
		
		model.addAttribute("members", members);
		return "member/list";
	}
}

