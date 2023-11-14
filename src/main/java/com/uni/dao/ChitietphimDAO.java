package com.uni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Chitietphim;

public interface ChitietphimDAO extends JpaRepository<Chitietphim, String> {

	
	@Query("SELECT ct FROM Chitietphim ct WHERE ct.film.Maphim=?1")
	Chitietphim findByPhim(String maphim);


	

}
