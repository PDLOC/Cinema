package com.uni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.entity.Vaitro;
import com.uni.service.VaitroService;

@RestController
@RequestMapping("/rest/vaitro")
public class VaitroRestController {
	@Autowired
	VaitroService vaitroService;

	@GetMapping
	public List<Vaitro> getAll() {
		return vaitroService.findAll();
	}

}
