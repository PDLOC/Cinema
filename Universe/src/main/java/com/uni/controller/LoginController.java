package com.uni.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.TaiKhoan;
import com.uni.service.TaikhoanService;


@Controller
@RequestMapping("home")
public class LoginController {
	@Autowired
	TaikhoanService taikhoanService;
	
	@RequestMapping("login/form")
	public String login(Model model) {
		model.addAttribute("message","Vui lòng đăng nhập!");
		return "home/register_login/login";
	}
	
	@RequestMapping("login/success")
	public String success(Model model) {
		model.addAttribute("message","Đăng nhập thành công!");
		return "home/register_login/login"; 
	}
	
	@RequestMapping("login/error")
	public String error(Model model) {
		model.addAttribute("message","Đăng nhập không thành công!");
		return "home/register_login/login"; 
	}
}
