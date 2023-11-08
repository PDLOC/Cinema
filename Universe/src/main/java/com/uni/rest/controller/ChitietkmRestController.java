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

import com.uni.entity.Chitietkm;
import com.uni.service.ChitietkmService;

@RestController
@RequestMapping("/rest/chitietkm")
public class ChitietkmRestController {
	@Autowired
	ChitietkmService chitietkmService;
	
	@GetMapping()
	public List<Chitietkm> findAll() {
		return chitietkmService.findAll();
	}
	
	@GetMapping("{stt}")
	public Chitietkm findById(@PathVariable("stt")Integer stt) {
		return chitietkmService.findById(stt);
	}
	
	@PostMapping
	public Chitietkm create(@RequestBody Chitietkm ctkm) {
		return chitietkmService.create(ctkm);
	}
	
	@PutMapping("{Makm}")
	public Chitietkm update(@RequestBody Chitietkm ctkm,@PathVariable("stt")Integer stt) {
		return chitietkmService.update(ctkm);
	}
	
	@DeleteMapping("{stt}")
	public void delete(@PathVariable("stt")Integer stt) {
		chitietkmService.delete(stt);
	}
}
