package com.uni.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Taikhoan;

@Service
public interface TaikhoanService {

	List<Taikhoan> getAdministrators();
	
	List<Taikhoan> findAll();

	Taikhoan create(Taikhoan tk);

	Taikhoan update(Taikhoan tk);

	
	
	void delete(String tk);

	Taikhoan findById(String matk);

	List<Taikhoan> findStaffAndAd();

	List<Object[]> top10Customer();

	Long getTotalTK();



}
