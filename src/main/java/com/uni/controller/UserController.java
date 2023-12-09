package com.uni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.entity.Taikhoan;
import com.uni.entity.Ve;
import com.uni.service.CookieService;
import com.uni.service.SessionService;
import com.uni.service.TaikhoanService;
import com.uni.service.VeService;

@Controller
@RequestMapping("home")
public class UserController {
	@Autowired
	TaikhoanService taikhoanService;
	@Autowired
	SessionService sessionService;
	@Autowired
	CookieService cookieService;
	@Autowired
	VeService veService;

	@RequestMapping("profile/{uname}")
	public String user(Model model, @PathVariable("uname") String uname) {
		// Hiện thông tin cá nhân
		Taikhoan taikhoan = taikhoanService.findById(uname);
		model.addAttribute("acc", taikhoan);

		// Hiện lịch sử đặt vé
		List<Ve> ve = veService.findByMatk(uname);
		model.addAttribute("listOrder", ve);
		return "home/profile-ticket/form";
	}

	@RequestMapping("profile/update")
	public String save(Model model, @ModelAttribute("account") Taikhoan taikhoan) {
		try {
			taikhoanService.update(taikhoan);
			model.addAttribute("acc", taikhoan);
			sessionService.set("login", taikhoan);
			model.addAttribute("message", "Cập nhật thành công");
			System.out.println("" + sessionService.get("login"));
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Cập nhật thất bại");
		}
		return "redirect:/home/profile/"+taikhoan.getMatk();
	}

	@RequestMapping("profile/change-pass")
	public String save1(@RequestParam("matk") String username, @RequestParam("password") String oldPassword,
			@RequestParam("newpassword") String newPassword, @RequestParam("retypepassword") String retypePassword,
			Model model) {
		Taikhoan taikhoan = taikhoanService.findById(username);
		model.addAttribute("acc", taikhoan);
		System.out.println(taikhoan);
		if (taikhoan.getMatkhau().equals(oldPassword)) {
			if (newPassword.equals("")) {
				model.addAttribute("message", "Mật khẩu mới không được để trống");
			}
			if (newPassword.equals(retypePassword)) {
				taikhoan.setMatkhau(newPassword);
				taikhoanService.update(taikhoan);
				sessionService.set("login", taikhoan);
				System.out.println("" + sessionService.get("login"));
				return "redirect:/home/film";
			} else {
				model.addAttribute("message", "Không trùng khớp với mật khẩu mới!!!");
			}
		} else {
			model.addAttribute("message", "Vui lòng nhập mật khẩu cũ !!!");
		}
		return "redirect:/home/profile/"+username;
	}

}