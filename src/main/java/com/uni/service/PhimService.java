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

	Phim create(Phim phim);

	Phim update(Phim phim);

	void delete(String phim);

	List<Object[]> top10phim();

	Long getTotalPhim();

}
