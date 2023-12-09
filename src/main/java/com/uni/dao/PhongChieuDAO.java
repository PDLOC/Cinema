package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Room;

public interface PhongChieuDAO extends JpaRepository<Room, String> {
	
	@Query(value ="SELECT * FROM  Phong ORDER BY Mapc DESC", nativeQuery = true)
	List<Room> findAllVeByDescending();
}
