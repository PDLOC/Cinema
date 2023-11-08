package com.uni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.uni.entity.Taikhoan;

import com.uni.service.TaikhoanService;

@RestController
@RequestMapping("/rest/customers")
public class TaikhoanRestController {
	@Autowired
	TaikhoanService tkService;
	
	@GetMapping
	public List<Taikhoan> getAll() {
		return tkService.findAll();
	}
	@GetMapping("{Matk}")
	public Taikhoan findById(@PathVariable("Matk")String matk) {
		return tkService.findById(matk);
	}
	
	@PostMapping
	public Taikhoan create(@RequestBody Taikhoan tk) {
		return tkService.create(tk);
	}
	
	@PutMapping("{Matk}")
	public Taikhoan update(@RequestBody Taikhoan tk,@PathVariable("Matk")String matk) {
		return tkService.update(tk);
	}
	
	@DeleteMapping("{Matk}")
	public void delete(@PathVariable("Matk")String tk) {
		tkService.delete(tk);
	}
}
