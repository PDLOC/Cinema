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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uni.entity.Ghe;
import com.uni.service.GheService;

@RestController
@RequestMapping("/rest/ghe")
public class GheRestController {
	@Autowired
	GheService gheService;
	
	@GetMapping
	public List<Ghe> findAll() {
		return gheService.findAll();
	}
	
	@GetMapping("/checkstatus/{maghe}")
	public Ghe checkStatus(@PathVariable("maghe")Integer maghe) {
		
		return gheService.findStatus(maghe);
	}
	
	@GetMapping("{Maghe}")
	public Ghe findById(@PathVariable("Maghe")Integer maghe) {
		return gheService.findById(maghe);
	}
	
	@GetMapping("{mapc}")
	public List<Ghe> findByPhong(@PathVariable("mapc")String mapc){
		return gheService.findByMaphong(mapc);
	}
	
	@PostMapping
	public Ghe create(@RequestBody Ghe ghe) {
		return gheService.create(ghe);
	}
	
	@PutMapping("/update/{Maghe}")
	public Ghe update(@RequestBody Ghe ghe,@PathVariable("Maghe")Integer id) {
		return gheService.update(ghe);
	}
	
	@PutMapping("{Maghe}")
	public Ghe updateTrangthai(@RequestBody Ghe ghe,@PathVariable("Maghe")Integer id) {
		return gheService.updateTrangthai(ghe);
	}
	
	@DeleteMapping("{Maghe}")
	public void delete(@PathVariable("Maghe")Integer maghe) {
		gheService.delete(maghe);
	}
	
}