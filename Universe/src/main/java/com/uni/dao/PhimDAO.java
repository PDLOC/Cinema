package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Phim;

public interface PhimDAO extends JpaRepository<Phim, String> {
	
}
