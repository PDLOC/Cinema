package com.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.Taikhoan;
import com.uni.service.CookieService;
import com.uni.service.SessionService;
import com.uni.service.TaikhoanService;

@Controller
@RequestMapping("home")
public class UserController {
	@Autowired
	TaikhoanService taikhoanService;
	@Autowired
	SessionService sessionService;
	@Autowired
	CookieService cookieService;

	@RequestMapping("profile/{uname}")
	public String user(Model model, @PathVariable("uname") String uname) {
		Taikhoan taikhoan = taikhoanService.findById(uname);
		model.addAttribute("acc", taikhoan);
		return "home/profile-ticket/form";
	}

	@RequestMapping("profile/update")
	public String save(Model model, @ModelAttribute("account") Taikhoan taikhoan) {
		taikhoanService.update(taikhoan);
		model.addAttribute("acc", taikhoan);
		sessionService.set("login", taikhoan);
		System.out.println(""+sessionService.get("login"));
		return "home/profile-ticket/form";
	}
}