package com.uni.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uni.entity.Ve;

public interface VeDAO extends JpaRepository<Ve, String>{

	@Query(value = "SELECT * FROM Ve  WHERE matk=?1 ORDER BY mave DESC", nativeQuery = true)
	List<Ve> findByMatk(String uname);
	@Query(value ="SELECT * FROM  Ve ORDER BY mave DESC", nativeQuery = true)
	List<Ve> findAllVeByDescending();
	
	@Query(value = "Select count(*) from Ve where Ngaygiaodich = CAST( GETDATE() AS Date)",nativeQuery= true)
	Long getTodayVe();		
			
			
			
	@Query(value = "SELECT t.last7Days AS 'date', ISNULL(SUM(t1.Thanhtien), 0) AS 'totalPayment'\r\n"
			+ "FROM (\r\n"
			+ "    SELECT CAST(GETDATE() AS DATE) AS last7Days\r\n"
			+ "    UNION ALL\r\n"
			+ "    SELECT DATEADD(DAY, -1, CAST(GETDATE() AS DATE))\r\n"
			+ "    UNION ALL\r\n"
			+ "    SELECT DATEADD(DAY, -2, CAST(GETDATE() AS DATE))\r\n"
			+ "    UNION ALL\r\n"
			+ "    SELECT DATEADD(DAY, -3, CAST(GETDATE() AS DATE))\r\n"
			+ "    UNION ALL\r\n"
			+ "    SELECT DATEADD(DAY, -4, CAST(GETDATE() AS DATE))\r\n"
			+ "    UNION ALL\r\n"
			+ "    SELECT DATEADD(DAY, -5, CAST(GETDATE() AS DATE))\r\n"
			+ "    UNION ALL\r\n"
			+ "    SELECT DATEADD(DAY, -6, CAST(GETDATE() AS DATE))\r\n"
			+ "    UNION ALL\r\n"
			+ "    SELECT DATEADD(DAY, -7, CAST(GETDATE() AS DATE))\r\n"
			+ ") t\r\n"
			+ "LEFT JOIN Ve t1 ON CAST(t1.Ngaygiaodich AS DATE) = CAST(t.last7Days AS DATE)\r\n"
			+ "GROUP BY CAST(t.last7Days AS DATE)", nativeQuery = true)
	List<Object[]> getRevenueLast7Days();


}
