package com.uni.dao;

import java.sql.Time;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Lich;


public interface LichDAO extends JpaRepository<Lich, Integer> {

	@Query("SELECT DISTINCT l.Ngaychieu FROM Lich l WHERE l.ctphims.Mact=?1")
	List<Date> findByMact(String mact);

	
	@Query("SELECT l FROM Lich l WHERE l.ctphims.Mact=?1")
	List<Lich> findByMatct(String mact);

	@Query(value ="SELECT * FROM  lich ORDER BY stt DESC", nativeQuery = true)
	List<Lich> findAllByLichDescending();
	
}
	
