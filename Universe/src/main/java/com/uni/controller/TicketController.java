package com.uni.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uni.service.ChitietphimService;
import com.uni.entity.Chitietphim;
import com.uni.entity.Lich;

@Controller
@RequestMapping("home")
public class TicketController {
	
	@Autowired
	ChitietphimService CtphimService;
	
	@RequestMapping("booking/ticket/{mact}/{gioBatDau}")
	public String ticket(Model model,@PathVariable("mact") String mact,@PathVariable("gioBatDau") String Giobatdau) {
		
		Chitietphim CtPhim = CtphimService.findById(mact);
		
		//Hiển thị Giờ bắt đầu và Giờ kết thúc
		String NgayChieu = null;
		String GioChieu = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Lich L : CtPhim.getListlich()) {
			if (L.getGiobatdau().toString().contains(Giobatdau)) {
				model.addAttribute("itemL",L);
			}
		}
		
		model.addAttribute("itemCt",CtPhim);
		
		//suất chiếu		
		
		return "home/seat/bookseat";
	}
}
