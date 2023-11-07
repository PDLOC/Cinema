package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{
	@Query("Select a From Authority a where a.taikhoan.username like ?1")
	List<Authority> getOneByRole(String username);
}
