package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Authority;

@Service
public interface AuthorityService {

	List<Authority> findAll();
	
	List<Authority> getOneByRole(String username);

}
