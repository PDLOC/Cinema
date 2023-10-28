package com.uni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.entity.Nhanvien;
import com.uni.service.NhanVienService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/staff")
public class NhanVienRestController {
	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping
	public List<Nhanvien> getAll(){
		return nhanVienService.findAll();
	}
	
	
}
