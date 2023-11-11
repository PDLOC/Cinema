package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Phim;

public interface PhimDAO extends JpaRepository<Phim, String> {
	
	@Query("SELECT p FROM Phim p WHERE p.trangthai.Stt=1")
	List<Phim> findPhimDangChieu();

	@Query("SELECT p FROM Phim p WHERE p.trangthai.Stt=2")
	List<Phim> findPhimSapChieu();
	
}