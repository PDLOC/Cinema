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

import com.uni.entity.Ghe;
import com.uni.entity.Loaighe;
import com.uni.service.GheService;
import com.uni.service.LoaiGheService;

@RestController
@RequestMapping("/rest/loaighe")
public class LoaiGheRestController {
	@Autowired
	LoaiGheService loaiGheService;
	
	@GetMapping
	public List<Loaighe> findAll() {
		return loaiGheService.findAll();
	}
	
	@GetMapping("{Maloai}")
	public Loaighe findById(@PathVariable("Maloai")String maloai) {
		return loaiGheService.findById(maloai);
	}
	
	@PostMapping
	public Loaighe save(@RequestBody Loaighe loaighe) {
		return loaiGheService.save(loaighe);
	}
	
	
	@PutMapping("{Maloai}")
	public Loaighe updateTrangthai(@RequestBody Loaighe loaighe,@PathVariable("Maloai")String id) {
		return loaiGheService.update(loaighe);
	}
	
	@DeleteMapping("{Maloai}")
	public void delete(@PathVariable("Maloai")String maghe) {
		loaiGheService.delete(maghe);
	}
	
}