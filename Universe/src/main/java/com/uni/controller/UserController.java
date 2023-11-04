package com.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.Taikhoan;
import com.uni.service.TaikhoanService;

@Controller
@RequestMapping("home")
public class UserController {
	@Autowired
	TaikhoanService taikhoanService;
	
	
	@RequestMapping("myticket/{acc}")
	public String user(Model model, @PathVariable("acc")String acc) {
		Taikhoan taikhoan = new Taikhoan();
		model.addAttribute("acc", taikhoan);
		taikhoan = taikhoanService.findById(acc);
		model.addAttribute("user",taikhoan);
		return "home/myTicket/form";
	}
	
}