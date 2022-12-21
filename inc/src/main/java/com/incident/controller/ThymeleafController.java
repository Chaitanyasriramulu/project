package com.incident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {	

	@GetMapping({"/Homepage"})
	public String homepage(){
		return "Homepage";
	}
	@GetMapping({"/Inc"})
	public String inc(){
		return "Inc";
	}
	@GetMapping({"/Home"})
	public String home(){
		return "Home";
	}
	@GetMapping({"/Login"})
	public String login(){
		return "Login";
	}
	@GetMapping({"/RaiseInc"})
	public String raiseInc(){
		return "raiseInc";
	}
}

