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
import com.uni.entity.Room;
import com.uni.service.PhongChieuService;

@RestController
@RequestMapping("/rest/phong")
public class PhongChieuRestController {
	@Autowired
	PhongChieuService phongChieuService;
	
	@GetMapping
	public List<Room> findAll(){
		return phongChieuService.findAllDesc();
	}
	
	@PostMapping
	public Room create(@RequestBody Room room) {
		return phongChieuService.create(room);
	}
	
	@PutMapping("{Mapc}")
	public Room update(@RequestBody Room room,@PathVariable("Mapc")String id) {
		return phongChieuService.update(room);
	}
	
	@DeleteMapping("{Mapc}")
	public void delete(@PathVariable("Mapc")String id) {
		phongChieuService.delete(id);
	}
	
}
