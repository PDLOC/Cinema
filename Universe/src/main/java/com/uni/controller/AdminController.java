package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class AdminController {
	@RequestMapping("admin")
	public String admin() {
		
		return "admin/admin.html";
	}
	@RequestMapping("chart")
	public String chart() {
		
		return "admin/chart/charts.html";
	}
	@RequestMapping("404")
	public String error() {
		
		return "admin/error/404.html";
	}
	@RequestMapping("table")
	public String table() {
		
		return "admin/table/table.html";
	}
	@RequestMapping("bank")
	public String bank() {
		
		return "admin/bank/bank.html";
	}
	@RequestMapping("card")
	public String card() {
		
		return "admin/card/card.html";
	}
}
