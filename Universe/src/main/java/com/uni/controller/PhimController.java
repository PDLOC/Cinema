package com.uni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.Film;
import com.uni.service.PhimService;
import com.uni.service.PhongChieuService;

@Controller
@RequestMapping("home")
public class PhimController {
	
	@Autowired
	PhimService phimService;
	
	@Autowired
	PhongChieuService pcService;
	
	@RequestMapping("film")
	public String phim(Model model) {
		List<Film> listPhim = phimService.findAll();
		model.addAttribute("items",listPhim);
		return "home/view";
	}
	
//	@RequestMapping("film/detail/${id}")
//	public String detail(Model model, @PathVariable("id") Integer id) {
//		
//		return "home/detail/detail.html";
//	}
}
