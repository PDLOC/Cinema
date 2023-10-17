package com.uni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.Phim;
import com.uni.service.PhimService;

@Controller
@RequestMapping("home")
public class PhimController {
	@Autowired
	PhimService phimService;
	
	
	@RequestMapping("film")
	public String phim(Model model) {
		List<Phim> list = phimService.findAll();
		model.addAttribute("items",list);
		return "home/view";
	}
}
