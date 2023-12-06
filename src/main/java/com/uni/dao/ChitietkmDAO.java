package com.uni.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Chitietkm;



public interface ChitietkmDAO extends JpaRepository<Chitietkm, Integer>{

	
	@Query("SELECT a FROM Chitietkm a WHERE a.khuyenmai.makm=?1")
	Chitietkm findByMa(String makm);
	
	@Query(value ="SELECT * FROM  Chitietkm ORDER BY makm DESC", nativeQuery = true)
	List<Chitietkm> findAllChitietkmByDescending();
}
