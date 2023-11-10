package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Ve;

public interface VeDAO extends JpaRepository<Ve, String>{

	@Query("SELECT a FROM Ve a WHERE a.taikhoan.matk=?1")
	List<Ve> findByMatk(String uname);

}
