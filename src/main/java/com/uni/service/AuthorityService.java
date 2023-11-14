package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Phanquyen;

@Service
public interface AuthorityService {

	List<Phanquyen> findAll();
	
	List<Phanquyen> getOneByRole(String username);

	Long getTotalCustomer();

}
