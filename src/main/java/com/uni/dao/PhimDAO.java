package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Phim;
import com.uni.entity.Ve;

public interface PhimDAO extends JpaRepository<Phim, String> {
	
	@Query("SELECT p FROM Phim p WHERE p.trangthai.Stt=1")
	List<Phim> findPhimDangChieu();

	@Query("SELECT p FROM Phim p WHERE p.trangthai.Stt=2")
	List<Phim> findPhimSapChieu();
	
	@Query(value ="SELECT * FROM phim \r\n"
			+ "ORDER BY CAST(SUBSTRING(Maphim, 2, LEN(Maphim)) AS INT) DESC", nativeQuery = true)
	List<Phim> findAllPhim();
	
	@Query(value="Select top 10 ve.Tenphim, count(MaVe) as mostSold \r\n"
			+ "			From Ve \r\n"
			+ "			GROUP BY  ve.Tenphim\r\n"
			+ "			Order by mostSold desc",nativeQuery = true)
	List<Object[]> top10phim();
}
