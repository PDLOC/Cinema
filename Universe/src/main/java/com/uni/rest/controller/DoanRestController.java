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

import com.uni.entity.Doan;
import com.uni.service.DoAnService;

@RestController
@RequestMapping("/rest/food")
public class DoanRestController {
	@Autowired
	DoAnService doAnService;
	
	@GetMapping
	public List<Doan> getAll() {
		return doAnService.findAll();
	}
	@GetMapping("{Mada}")
	public Doan getOne(@PathVariable("Mada")Integer mada) {
		return doAnService.findById(mada);
	}
	
	@PostMapping
	public Doan create(@RequestBody Doan doan) {
		return doAnService.create(doan);
	}
	
	@PutMapping("{Mada}")
	public Doan update(@RequestBody Doan doan,@PathVariable("Mada")Integer id) {
		return doAnService.update(doan);
	}
	
	@DeleteMapping("{Mada}")
	public void delete(@PathVariable("Mada")Integer id) {
		doAnService.delete(id);
	}
}
