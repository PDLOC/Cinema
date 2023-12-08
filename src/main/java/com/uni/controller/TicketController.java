package com.uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.uni.controller.PaymentController;
import com.uni.service.ChitietphimService;
import com.uni.entity.Chitietphim;
import com.uni.entity.Lich;
import com.uni.entity.Loaighe;
import com.uni.entity.Combo;
import com.uni.entity.Ghe;
import com.uni.entity.Khuyenmai;
import com.uni.service.KmService;
import com.uni.service.LoaiGheService;
import com.uni.service.SessionService;
import com.uni.service.impl.MailerServiceImpl;
import com.uni.service.ComboService;
import com.uni.service.GheService;

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
	GheService gheService;
	
	@Autowired
	ComboService comboService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	MailerServiceImpl mailer;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("booking/ticket/{mapc}/{mact}/{gioBatDau}")
	public String ticket(Model model,@PathVariable("mapc") String mapc,@PathVariable("mact") String mact,@PathVariable("gioBatDau") String Giobatdau) {
		Chitietphim CtPhim = CtphimService.findById(mact);
		//Hiển thị Giờ bắt đầu và Giờ kết thúc
		for (Lich L : CtPhim.getListlich()) {
			if (L.getGiobatdau().toString().contains(Giobatdau)) {
				model.addAttribute("itemL",L);
				System.out.println(L.getStt());
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
		
		//Ghế
		List<Ghe> ghe = gheService.findByMaphong(mapc);
		model.addAttribute("listGhe",ghe);
		
		return "home/seat/bookseat";
	}
	
	
	@RequestMapping("booking/ticket/pay/{totalPay}")
	public String payment(@PathVariable("totalPay") long totalpay) {
		PaymentController pc = new PaymentController();
		String urlpay = null;
		try {
			urlpay = pc.payment(totalpay);
		} catch (Exception e) {
			System.out.print(e);
		}
		return "redirect:"+urlpay;
	}
	
	@RequestMapping("booking/SendBill")
	public String sendMail() {
		 
		try {
			String username = sessionService.get("tenphim");
//			mailer.send("hoaidthps21446@fpt.edu.vn", "test", "hello");
			System.out.print(username);
		} catch (Exception e) {
			System.out.print("error");
		}
		
		return "redirect:/home/film";
	}
}
