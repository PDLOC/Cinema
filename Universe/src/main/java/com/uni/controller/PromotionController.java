package com.uni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.Khuyenmai;
import com.uni.service.KmService;

@Controller
@RequestMapping("home")
public class PromotionController {
	@Autowired
	KmService kmService;
	
	@RequestMapping("promotion")
	public String promotion(Model model) {
		List<Khuyenmai> listKM = kmService.findAll();
		model.addAttribute("listkm",listKM);
		
		return "home/promotion/promotion";
	}
	
	@RequestMapping("/promotion/detail/{makm}")
	public String promotion(Model model,@PathVariable("makm") String makm) {
		Khuyenmai km = kmService.findById(makm);
		model.addAttribute("listkm",km);
		return "home/promotion/detail";
	}
}