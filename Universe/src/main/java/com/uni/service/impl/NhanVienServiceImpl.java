package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.NhanVienDAO;
import com.uni.entity.Nhanvien;
import com.uni.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {
	@Autowired
	NhanVienDAO nhanVienDAO;

	@Override
	public List<Nhanvien> findAll() {
		// TODO Auto-generated method stub
		return nhanVienDAO.findAll();
	}
}
