package com.uni.service;

import org.springframework.stereotype.Service;

import com.uni.entity.TaiKhoan;

@Service
public interface TaikhoanService {

	TaiKhoan findById(String username);

}
