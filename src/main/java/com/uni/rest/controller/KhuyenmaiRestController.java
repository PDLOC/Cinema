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

import com.uni.entity.Khuyenmai;
import com.uni.service.KmService;

@RestController
@RequestMapping("/rest/khuyenmai")
public class KhuyenmaiRestController {
	@Autowired
	KmService kmService;
	
	@GetMapping()
	public List<Khuyenmai> findAll() {
		return kmService.findAllExcept();
	}
	
	@GetMapping("{Makm}")
	public Khuyenmai findById(@PathVariable("Makm")String makm) {
		return kmService.findById(makm);
	}
	
	@PostMapping
	public Khuyenmai create(@RequestBody Khuyenmai km) {
		return kmService.create(km);
	}
	
	@PutMapping("{Makm}")
	public Khuyenmai update(@RequestBody Khuyenmai km,@PathVariable("Makm")String makm) {
		return kmService.update(km);
	}
	
	@DeleteMapping("{Makm}")
	public void delete(@PathVariable("Makm")String makm) {
		kmService.delete(makm);
	}
}
