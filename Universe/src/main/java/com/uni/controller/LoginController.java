package com.uni.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.Taikhoan;
import com.uni.service.TaikhoanService;

@Controller
@RequestMapping("home")
public class LoginController {
	@Autowired
	TaikhoanService taikhoanService;

	@RequestMapping("login/form")
	public String login(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập!");
		return "home/register_login/login";
	}

	@RequestMapping("login/success")
	public String success(Model model) {
		model.addAttribute("swal1", "dn");
		return "redirect:/home/film";
	}

	@RequestMapping("login/error")
	public String error(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập lại!");
		return "home/register_login/login";
	}

	@RequestMapping("logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Bạn đã đăng xuất!");
		return "redirect:/home/film";
	}
}
