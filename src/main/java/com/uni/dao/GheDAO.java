package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Ghe;

public interface GheDAO extends JpaRepository<Ghe, Integer> {
	
	@Query(value = "SELECT * FROM GHE WHERE PHONGCHIEUID LIKE ?1", nativeQuery = true)
	List<Ghe> findByMaphong(String mapc);

	
	@Query(value = "SELECT * FROM GHE WHERE TENGHE LIKE ?1", nativeQuery = true)
	Ghe findByTenGhe(String tenghe);

	@Query(value = "UPDATE GHE SET Trangthai = 1 WHERE Maghe ?1", nativeQuery = true)
	Ghe updateTrangthai(Ghe ghe);

	@Query(value = "SELECT * FROM Ghe WHERE Maghe=?1", nativeQuery = true)
	Ghe findStatus(Integer maghe);
	
	
}
