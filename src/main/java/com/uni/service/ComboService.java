package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Combo;
import com.uni.entity.Doan;



@Service
public interface ComboService {

	List<Combo> findAll();

	Combo findById(Integer stt);

	Combo create(Combo combo);

	Combo update(Combo combo);

	void delete(Integer combo);




	
	
}
