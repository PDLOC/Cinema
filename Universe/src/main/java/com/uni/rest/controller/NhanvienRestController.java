package com.uni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.entity.Taikhoan;
import com.uni.service.TaikhoanService;

@RestController
@RequestMapping("/rest/staff")
public class NhanvienRestController {
	@Autowired
	TaikhoanService taikhoanService;
	
	@GetMapping()
	public List<Taikhoan> findNV(){
		
		return taikhoanService.findStaffAndAd();
	}
}
