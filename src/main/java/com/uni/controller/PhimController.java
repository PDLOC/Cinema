package com.uni.controller;

import java.net.URLEncoder;
import java.security.Principal;
import java.sql.Time;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.entity.Chitietphim;
import com.uni.entity.Lich;
import com.uni.entity.Phim;
import com.uni.entity.Taikhoan;
import com.uni.service.ChitietphimService;
import com.uni.service.CookieService;
import com.uni.service.LichService;
import com.uni.service.PhimService;
import com.uni.service.PhongChieuService;
import com.uni.service.SessionService;
import com.uni.service.TaikhoanService;

@Controller
@RequestMapping("home")
public class PhimController {

	@Autowired
	PhimService phimService;

	@Autowired
	ChitietphimService chitietphimService;

	@Autowired
	PhongChieuService pcService;

	@Autowired
	TaikhoanService taikhoanService;

	@Autowired
	LichService lichService;

	@Autowired
	SessionService sessionService;

	@Autowired
	CookieService cookieService;

	@RequestMapping("film")
	public String phim(Model model, Principal principal, HttpServletResponse response, HttpSession session)
			throws Exception {
		// Hiển thị khi đăng ký thành công
		List<Taikhoan> listTk = taikhoanService.findAll();
		int a = listTk.size();
		int flag = 0;
		for (int i = 0; i < listTk.size(); i++) {
			if (a > listTk.size()) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			model.addAttribute("swal", "tc");
		} else {
			model.addAttribute("swal", null);
		}

		// Tìm qua spring security
		if (principal != null) {
			Authentication authentication = (Authentication) principal;
			User user = (User) authentication.getPrincipal();
			Taikhoan taikhoan = taikhoanService.findById(user.getUsername());
			sessionService.set("login", taikhoan);
			cookieService.add("USERNAME", taikhoan.getMatk(), 2);
			model.addAttribute("hoten", taikhoan.getHoten());
			model.addAttribute("displayed", "dn");
			//System.out.println("" + sessionService.get("login"));

		} else {
			model.addAttribute("displayed", null);
			sessionService.remove("login");
			cookieService.add("USERNAME", "", 0);
		}

		List<Phim> listPhim = phimService.findAll();
		List<Phim> listPhimDangChieu = phimService.findPhimDangChieu();
		List<Phim> listPhimSapChieu = phimService.findPhimSapChieu();
		model.addAttribute("imageF", listPhim);
		model.addAttribute("items", listPhimDangChieu);
		model.addAttribute("items1", listPhimSapChieu);
		return "home/view";
	}

	@RequestMapping("film/detail/{maphim}")
	public String detail(Model model, @PathVariable("maphim") String maphim) {
		Phim p = phimService.findById(maphim);
		model.addAttribute("item", p);
		Chitietphim ct = chitietphimService.findByPhim(maphim);
		List<Date> ngay = lichService.findByMact(ct.getMact());
		model.addAttribute("listL", ngay);
		List<Lich> list = lichService.findByMatct(ct.getMact());
		model.addAttribute("listLich2", list);
		return "home/detail/detail";
	}
	
}
