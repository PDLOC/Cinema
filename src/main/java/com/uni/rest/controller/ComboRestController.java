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

import com.uni.entity.Combo;
import com.uni.service.ComboService;
import com.uni.service.DoAnService;

@RestController
@RequestMapping("/rest/combo")
public class ComboRestController {
	@Autowired
	ComboService comBoService;
	
	@GetMapping
	public List<Combo> getAll() {
		return comBoService.findAll();
	}
	@GetMapping("{Stt}")
	public Combo getOne(@PathVariable("Stt")Integer stt) {
		return comBoService.findById(stt);
	}
	
	@PostMapping
	public Combo create(@RequestBody Combo stt) {
		return comBoService.create(stt);
	}
	
	@PutMapping("{Stt}")
	public Combo update(@RequestBody Combo combo,@PathVariable("Stt")Integer id) {
		return comBoService.update(combo);
	}
	
	@DeleteMapping("{Stt}")
	public void delete(@PathVariable("Stt")Integer id) {
		comBoService.delete(id);
	}
}
