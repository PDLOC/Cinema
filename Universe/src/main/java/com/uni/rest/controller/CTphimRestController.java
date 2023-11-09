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

import com.uni.entity.Chitietphim;
import com.uni.entity.Phim;
import com.uni.service.ChitietphimService;
import com.uni.service.PhimService;

@RestController
@RequestMapping("/rest/ctphim")
public class CTphimRestController {
	@Autowired
	ChitietphimService ctphimService;
	
	@GetMapping
	public List<Chitietphim> getAll() {
		return ctphimService.findAll();
	}
	@GetMapping("{Mact}")
	public Chitietphim getOne(@PathVariable("Mact")String maCtphim) {
		return ctphimService.findById(maCtphim);
	}
	
	@PostMapping
	public Chitietphim create(@RequestBody Chitietphim maCtphim) {
		return ctphimService.create(maCtphim);
	}
	
	@PutMapping("{Mact}")
	public Chitietphim update(@RequestBody Chitietphim maCtphim,@PathVariable("Mact")String id) {
		return ctphimService.update(maCtphim);
	}
	
	@DeleteMapping("{Mact}")
	public void delete(@PathVariable("Mact")String id) {
		ctphimService.delete(id);
	}
}
