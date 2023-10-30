package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Khachhang;

@Service
public interface KhachHangService {

	List<Khachhang> findAll();

}
