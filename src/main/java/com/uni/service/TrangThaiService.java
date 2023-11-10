package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Trangthai;





@Service
public interface TrangThaiService {

	List<Trangthai> findAll();
	

	
}
