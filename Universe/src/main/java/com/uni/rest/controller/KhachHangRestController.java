package com.uni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.entity.Khachhang;
import com.uni.service.KhachHangService;

@RestController
@RequestMapping("/rest/customers")
public class KhachHangRestController {
	@Autowired
	KhachHangService khachHangService;
	
	@GetMapping
	public List<Khachhang> getAll() {
		return khachHangService.findAll();
	}
	
	
}
