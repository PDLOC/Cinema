package com.uni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Chitietkm;

public interface ChitietkmDAO extends JpaRepository<Chitietkm, Integer>{

	
	@Query("SELECT a FROM Chitietkm a WHERE a.khuyenmai.makm=?1")
	Chitietkm findByMa(String makm);

}
