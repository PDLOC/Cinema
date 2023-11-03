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

import com.uni.entity.Phim;
import com.uni.service.PhimService;

@RestController
@RequestMapping("/rest/phim")
public class PhimRestController {
	@Autowired
	PhimService phimService;
	
	@GetMapping
	public List<Phim> getAll() {
		return phimService.findAll();
	}
	@GetMapping("{Maphim}")
	public Phim getOne(@PathVariable("Maphim")String maphim) {
		return phimService.findById(maphim);
	}
	
	@PostMapping
	public Phim create(@RequestBody Phim maphim) {
		return phimService.create(maphim);
	}
	
	@PutMapping("{Maphim}")
	public Phim update(@RequestBody Phim maphim,@PathVariable("Maphim")String id) {
		return phimService.update(maphim);
	}
	
	@DeleteMapping("{Maphim}")
	public void delete(@PathVariable("Maphim")String id) {
		phimService.delete(id);
	}
}
