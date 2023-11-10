package com.uni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uni.entity.Phanquyen;
import com.uni.service.AuthorityService;

@RestController
@RequestMapping("rest")
public class AuthorityRestController {
	@Autowired
	AuthorityService authorityService;
	
	@GetMapping("authorities")
	public List<Phanquyen> getAll() {
		return authorityService.findAll();
	}
	
	@GetMapping("authoritiesOne")
	public List<Phanquyen> getOneByRole(@RequestParam("username")String username){
		return authorityService.getOneByRole(username);
	}
}
