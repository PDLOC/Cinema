package com.uni.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uni.entity.Ve;
import com.uni.service.VeService;

@RestController
@RequestMapping("/rest/ve")
public class VeRestController {
	@Autowired
	VeService veService;

	@Autowired
	ObjectMapper objectMapper;

	@GetMapping
	public List<Ve> getAll() {
		return veService.findAll();
	}

	@PostMapping
	public Ve booking(@RequestBody Ve ve, HttpSession session, String bookingInfo) {
		if (bookingInfo != null) {
			try {
				ve = objectMapper.readValue(bookingInfo, Ve.class);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return veService.create(ve);
	}

}
