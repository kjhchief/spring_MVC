package ezen.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		String message = "Spring @MVC";
		model.addAttribute("message", message);
		return "index";
	}
	

}
