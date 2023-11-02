package com.uni.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.uni.entity.Taikhoan;
import com.uni.service.TaikhoanService;

@Controller
@RequestMapping("home")
public class RegisterController {
	@Autowired
	TaikhoanService taikhoanService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("register")
	public String register(Model model) {
		Taikhoan taikhoan = new Taikhoan();
		model.addAttribute("acc", taikhoan);
		return "home/register_login/register";
	}
	
	@PostMapping("register/save")
	public String save(@Valid  @ModelAttribute("acc") Taikhoan tk, BindingResult result, Errors errors, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("swal", "tb");
			return "home/register_login/register";
		}else {
			taikhoanService.create(tk);
			return "redirect:/home/film";
		}
	}
	
}
