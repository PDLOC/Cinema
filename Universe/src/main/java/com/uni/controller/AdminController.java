package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	@RequestMapping("index")
	public String admin() {
		
		return "redirect:/assets/admin/index.html";
	}
	
	@RequestMapping("admin/nhanvien/form")
	public String formNV() {
		
		return "redirect:/assets/admin/nhanvien/form.html";
	}
	
	@RequestMapping("admin/nhanvien/list")
	public String listNV() {
		
		return "redirect:/assets/admin/nhanvien/list.html";
	}
	
}
