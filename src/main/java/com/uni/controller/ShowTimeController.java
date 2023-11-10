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
public class ShowTimeController {
	@Autowired
	PhimService phimService;
	
	@RequestMapping("movies")
	public String show(Model model) {
		List<Phim> listPhimDangChieu = phimService.findPhimDangChieu();
		model.addAttribute("listMovies", listPhimDangChieu);
		
		return "home/daytime/show";
	}
}
