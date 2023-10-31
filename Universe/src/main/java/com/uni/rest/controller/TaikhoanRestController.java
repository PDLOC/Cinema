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


import com.uni.entity.TaiKhoan;

import com.uni.service.TaikhoanService;

@RestController
@RequestMapping("/rest/customers")
public class TaikhoanRestController {
	@Autowired
	TaikhoanService tkService;
	
	@GetMapping
	public List<TaiKhoan> getAll() {
		return tkService.findAll();
	}
	@GetMapping("{Mada}")
	public TaiKhoan findById(@PathVariable("Mada")String mada) {
		return tkService.findById(mada);
	}
	
	@PostMapping
	public TaiKhoan create(@RequestBody TaiKhoan tk) {
		return tkService.create(tk);
	}
	
	@PutMapping("{Mada}")
	public TaiKhoan update(@RequestBody TaiKhoan tk,@PathVariable("Mada")String id) {
		return tkService.update(tk);
	}
	
	@DeleteMapping("{Mada}")
	public void delete(@PathVariable("Mada")String tk) {
		tkService.delete(tk);
	}
}
