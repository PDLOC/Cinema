package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Combo;


public interface ComboDAO extends JpaRepository<Combo, Integer> {
	
	@Query(value ="SELECT * FROM  Combo ORDER BY stt DESC", nativeQuery = true)
	
	List<Combo> findAllComboByDescending();
}
