package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Nhanvien;

@Service
public interface NhanVienService {

	List<Nhanvien> findAll();

}