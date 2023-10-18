package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Film;

@Service
public interface PhimService {

	List<Film> findAll();

	List<Film> findDistinctDuplicateTenPhim();
	
}
