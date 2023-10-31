package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Doan;



@Service
public interface DoAnService {
	List<Doan> findAll();

	Doan findById(Integer id);

	Doan create(Doan doan);

	void delete(Integer doan);

	Doan update(Doan doan);

	
}
