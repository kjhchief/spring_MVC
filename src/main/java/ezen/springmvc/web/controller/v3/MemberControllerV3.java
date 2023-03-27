package ezen.springmvc.web.controller.v3;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ezen.springmvc.domain.dto.Member;

/**
 * 실용적 컨트롤러 매핑
 * 스프링 @MVC는 개발자가 편리하게 컨트롤러를 개발할 수 있도록 많은 편의 기능 제공한다
 * 요청방식을 구분하지 않고 컨트롤러를 개발하는 것보다 요청방식을 구분하여 개발할 수 있다
 * 제약을 추가하는 좋은 설계이다
 * Postman으로 요청 테스트
 */
@Controller
//메소드 레벨의 중복된 요청 매핑을 클래스 레벨에서 설정할 수 있다
@RequestMapping("/springmvc/v3/members")
public class MemberControllerV3{
	
	//@RequestMapping(value="/register-form", method = RequestMethod.GET)
	@GetMapping("/register-form")
	public ModelAndView	registerForm() {
		return new ModelAndView("member/register-form");
	}
	
	//@RequestMapping(value="/register", method = RequestMethod.POST)
	@PostMapping("/register")
//	@DeleteMapping
//	@PatchMapping
	public ModelAndView	register(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		// 서비스 객체를 이용한 회원 등록
		// memberService.registerMember(member);
		
		ModelAndView mav = new ModelAndView("member/register-result");
		mav.addObject("member", member);
		return mav;
	}
	
	//@RequestMapping
	@GetMapping
	public ModelAndView	members() {
		// 서비스 객체를 이용한 회원 목록
		// List<Member> members = memberService.getMembers();
		List<Member> members = new ArrayList<>();
		members.add(new Member("홍길동1", 10));
		members.add(new Member("홍길동2", 20));
		members.add(new Member("홍길동3", 30));
		
		ModelAndView mav = new ModelAndView("member/list");
		mav.addObject("members", members);
		return mav;
	}
}

