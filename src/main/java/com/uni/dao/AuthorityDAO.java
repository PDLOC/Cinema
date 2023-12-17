package com.uni.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Phanquyen;

public interface AuthorityDAO extends JpaRepository<Phanquyen, Integer>{
	@Query("Select a From Phanquyen a where a.taikhoan.matk like ?1")
	List<Phanquyen> getOneByRole(String username);

	@Transactional
	@Modifying
	@Query(value = "Delete from Phanquyen where matk = ?1",nativeQuery = true)
	void deleteByUserName(String username);
}
