package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.TaiKhoan;

@Service
public interface TaikhoanService {

	TaiKhoan findById(String username);

	List<TaiKhoan> findAll();

	TaiKhoan create(TaiKhoan tk);

	TaiKhoan update(TaiKhoan tk);

	void delete(String tk);

}
