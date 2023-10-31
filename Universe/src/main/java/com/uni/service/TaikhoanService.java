package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.TaiKhoan;

@Service
public interface TaikhoanService {

	List<TaiKhoan> findAll();

	TaiKhoan create(TaiKhoan tk);

	TaiKhoan update(TaiKhoan tk);

	void delete(String tk);

	TaiKhoan findById(String matk);

}
