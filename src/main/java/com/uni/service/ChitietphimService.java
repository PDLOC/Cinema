package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Chitietphim;

@Service
public interface ChitietphimService {
	
	Chitietphim findById(String maCtphim);

	List<Chitietphim> findAll();

	Chitietphim create(Chitietphim maCtphim);

	Chitietphim update(Chitietphim maCtphim);

	void delete(String maCtphim);

	Chitietphim findByPhim(String maphim);

}
