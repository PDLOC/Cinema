package com.uni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.entity.Trangthai;
import com.uni.service.TrangThaiService;

@RestController
@RequestMapping("/rest/trangthai")
public class TrangthaiRestController {
	@Autowired
	private TrangThaiService trangThaiService;

	@GetMapping
	public List<Trangthai> getAll() {
		return trangThaiService.findAll();
	}

}
