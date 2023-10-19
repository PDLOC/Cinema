package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	@RequestMapping("nhanvien/form")
	public String formNhanvien(Model model) {
		return "admin/nhanvien/formNhanvien.html";
	}
	
	@RequestMapping("nhanvien/list")
	public String listNhanvien(Model model) {
		return "admin/nhanvien/listNhanvien.html";
	}
	
	@RequestMapping("khachhang/form")
	public String formKhachhang(Model model) {
		return "admin/khachhang/formKhachhang.html";
	}
	
	@RequestMapping("khachhang/list")
	public String listKhachhang(Model model) {
		return "admin/khachhang/listKhachhang.html";
	}
	
	@RequestMapping("doan/form")
	public String formDoan(Model model) {
		return "admin/doan/formDoan.html";
	}
	
	@RequestMapping("doan/list")
	public String listDoan(Model model) {
		return "admin/doan/listDoan.html";
	}
	
	@RequestMapping("phim/form")
	public String formPhim(Model model) {
		return "admin/phim/formPhim.html";
	}
	
	@RequestMapping("phim/list")
	public String listPhim(Model model) {
		return "admin/phim/listPhim.html";
	}
	
	@RequestMapping("loaiphim/form")
	public String formLoaiphim(Model model) {
		return "admin/loaiphim/formLoaiphim.html";
	}
	
	@RequestMapping("loaiphim/list")
	public String listLoaiphim(Model model) {
		return "admin/loaiphim/listLoaiphim.html";
	}
	
	@RequestMapping("khuyenmai/form")
	public String formKhuyenmai(Model model) {
		return "admin/khuyenmai/formKhuyenmai.html";
	}
	
	@RequestMapping("khuyenmai/list")
	public String listKhuyenmai(Model model) {
		return "admin/khuyenmai/listKhuyenmai.html";
	}
}
