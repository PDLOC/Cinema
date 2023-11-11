package com.uni.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Taikhoan;

public interface TaiKhoanDAO extends JpaRepository<Taikhoan, String> {
	@Query("Select Distinct ar.taikhoan From Phanquyen ar where ar.vaitro.Mavaitro IN ('STAFF','AD')")
	List<Taikhoan> getAdministrators();

	@Query("Select a.taikhoan From Phanquyen a where a.vaitro.Mavaitro IN ('STAFF','AD')")
	List<Taikhoan> findStaffandAd();



}