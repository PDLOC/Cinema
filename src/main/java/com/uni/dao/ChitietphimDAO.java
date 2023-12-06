package com.uni.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Chitietphim;


public interface ChitietphimDAO extends JpaRepository<Chitietphim, String> {

	
	@Query("SELECT ct FROM Chitietphim ct WHERE ct.film.Maphim=?1")
	Chitietphim findByPhim(String maphim);

	@Query(value ="SELECT * FROM chitietphim \r\n"
			+ "ORDER BY CAST(SUBSTRING(Maphim, 2, LEN(Maphim)) AS INT) DESC", nativeQuery = true)
	List<Chitietphim> findAllChitietphim();
	

}
