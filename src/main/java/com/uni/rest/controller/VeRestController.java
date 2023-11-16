package com.uni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.uni.entity.Ve;
import com.uni.service.VeService;

@RestController
@RequestMapping("/rest/ve")
public class VeRestController {
	@Autowired
	VeService veService;

	@GetMapping
	public List<Ve> getAll() {
		return veService.findAll();
	}

}
