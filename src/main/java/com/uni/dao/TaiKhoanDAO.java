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
  
	@Query(value="\r\n"
			+ "				Select a.matk, a.Hoten, a.email, a.Hinh, \r\n"
			+ "			sum(o.Thanhtien * o.Soluong) as totalPayment \r\n"
			+ "			From Taikhoan a inner join Ve o on a.Matk = o.Matk 			 \r\n"
			+ "			Group by a.Matk, a.Hoten, a.email, a.Hinh \r\n"
			+ "			order by totalPayment desc",nativeQuery = true)
	List<Object[]> top10Customer();
}
