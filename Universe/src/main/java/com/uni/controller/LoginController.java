package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class LoginController {
	@RequestMapping("login")
	public String login() {		
		
		return "home/sign_login/login";
	}
}
