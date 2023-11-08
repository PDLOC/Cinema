package com.uni.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Taikhoan;

public interface TaiKhoanDAO extends JpaRepository<Taikhoan, String> {
	@Query("Select Distinct ar.taikhoan From Authority ar where ar.vaitro.Mavaitro IN ('STAFF','AD')")
	List<Taikhoan> getAdministrators();

	@Query("Select a.taikhoan From Authority a where a.vaitro.Mavaitro IN ('STAFF','AD')")
	List<Taikhoan> findStaffandAd();

	@Transactional
	@Modifying
	@Query("UPDATE Taikhoan a SET a.password = ?1 WHERE a.username = ?2")
	void updatePass(String password, String username);

}
