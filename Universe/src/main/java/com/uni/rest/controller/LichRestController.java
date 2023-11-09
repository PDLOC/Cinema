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

import com.uni.entity.Lich;
import com.uni.service.LichService;



@RestController
@RequestMapping("/rest/lich")
public class LichRestController {
	@Autowired
	LichService lichService;
	
	@GetMapping
	public List<Lich> getAll() {
		return lichService.findAll();
	}
	@GetMapping("{Stt}")
	public Lich getOne(@PathVariable("Stt")Integer stt) {
		return lichService.findById(stt);
	}
	
	@PostMapping
	public Lich create(@RequestBody Lich stt) {
		return lichService.create(stt);
	}
	
	@PutMapping("{Stt}")
	public Lich update(@RequestBody Lich lich,@PathVariable("Stt")Integer id) {
		return lichService.update(lich);
	}
	
	@DeleteMapping("{Stt}")
	public void delete(@PathVariable("Stt")Integer id) {
		lichService.delete(id);
	}
}
