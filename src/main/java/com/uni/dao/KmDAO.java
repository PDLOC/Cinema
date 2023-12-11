package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Khuyenmai;


public interface KmDAO extends JpaRepository<Khuyenmai, String> {
//	@Query(value ="SELECT * FROM  Khuyenmai ORDER BY makm DESC", nativeQuery = true)
	@Query(value ="SELECT * FROM Khuyenmai ORDER BY CAST(SUBSTRING(makm,3,LEN(makm)) AS INT) DESC", nativeQuery = true)
	List<Khuyenmai> findAllKhuyenmaiByDescending();

	@Query(value = "SELECT * FROM Khuyenmai WHERE makm NOT LIKE 'km00'", nativeQuery = true)
	List<Khuyenmai> findAllExcept();
}
