package com.uni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.Chitietphim;
import com.uni.entity.Phim;
import com.uni.service.ChitietphimService;
import com.uni.service.PhimService;
import com.uni.service.PhongChieuService;

@Controller
@RequestMapping("home")
public class PhimController {
	
	@Autowired
	PhimService phimService;
	
	@Autowired
	ChitietphimService chitietphimService;
	
	@Autowired
	PhongChieuService pcService;
	
	@RequestMapping("film")
	public String phim(Model model) {
		List<Phim> listPhim = phimService.findAll();
		model.addAttribute("items",listPhim);
		return "home/view";
	}
	
	@RequestMapping("film/detail/{maphim}")
	public String detail(Model model, @PathVariable("maphim") String maphim) {
		Phim p = phimService.findById(maphim);
		Chitietphim ctp = chitietphimService.findById(maphim);
		System.out.println(p);
		model.addAttribute("item",p);
		return "home/detail/detail";
	}
}
