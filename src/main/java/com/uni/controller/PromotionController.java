package com.uni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.entity.Chitietkm;
import com.uni.entity.Khuyenmai;
import com.uni.service.ChitietkmService;
import com.uni.service.KmService;

@Controller
@RequestMapping("home")
public class PromotionController {
	@Autowired
	KmService kmService;
	@Autowired
	ChitietkmService chitietkmService;
	
	@RequestMapping("promotion")
	public String promotion(Model model) {
		List<Khuyenmai> listKM = kmService.findAllExcept();
		model.addAttribute("listkm",listKM);
		
		return "home/promotion/promotion";
	}
	
	@RequestMapping("/promotion/detail/{makm}")
	public String promotion(Model model,@PathVariable("makm") String makm) {
		//Khuyenmai km = kmService.findById(makm);
		Chitietkm chitietkm = chitietkmService.findByMa(makm);
		model.addAttribute("listkm",chitietkm);
		return "home/promotion/detail";
	}
}