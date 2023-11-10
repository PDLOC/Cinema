package com.uni.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.service.ChitietphimService;
import com.uni.entity.Chitietphim;
import com.uni.entity.Lich;
import com.uni.entity.Loaighe;
import com.uni.entity.Combo;
import com.uni.entity.Khuyenmai;
import com.uni.service.KmService;
import com.uni.service.LoaiGheService;
import com.uni.service.ComboService;

@Controller
@RequestMapping("home")
public class TicketController {
	
	@Autowired
	ChitietphimService CtphimService;
	
	@Autowired
	KmService khuyenMaiService;
	
	@Autowired 
	LoaiGheService LgheService;
	
	@Autowired
	ComboService comboService;
	
	@RequestMapping("booking/ticket/{mact}/{gioBatDau}")
	public String ticket(Model model,@PathVariable("mact") String mact,@PathVariable("gioBatDau") String Giobatdau) {
		Chitietphim CtPhim = CtphimService.findById(mact);
		//Hiển thị Giờ bắt đầu và Giờ kết thúc
		for (Lich L : CtPhim.getListlich()) {
			if (L.getGiobatdau().toString().contains(Giobatdau)) {
				model.addAttribute("itemL",L);
			}
		}
		model.addAttribute("itemCt",CtPhim);
		
		//loaiGhe
		List<Loaighe> Lghe = LgheService.findAll();
		model.addAttribute("itemLGhe",Lghe);
		
		//comBo
		List<Combo> combo = comboService.findAll();
		model.addAttribute("itemComBo",combo);
		
		//khuyen mai		
		List<Khuyenmai> km = khuyenMaiService.findAll();
		model.addAttribute("itemKM",km);
		
		return "home/seat/bookseat";
	}
	
}
