package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Film;

public interface PhimDAO extends JpaRepository<Film, Integer> {
	
	@Query("SELECT DISTINCT f FROM Film f WHERE f.Tenphim IN (SELECT f2.Tenphim FROM Film f2 GROUP BY f2.Tenphim HAVING COUNT(f2.Tenphim) > 1)")
    List<Film> findDistinctDuplicateTenPhim();
}
