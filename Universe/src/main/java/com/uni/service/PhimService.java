package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Phim;

@Service
public interface PhimService {

	List<Phim> findAll();

	Phim findById(String maphim);

	List<Phim> findPhimDangChieu();

	List<Phim> findPhimSapChieu();

}
