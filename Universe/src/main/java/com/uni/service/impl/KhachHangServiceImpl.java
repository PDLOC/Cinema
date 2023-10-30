package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.KhachHangDAO;
import com.uni.entity.Khachhang;
import com.uni.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{
	@Autowired
	KhachHangDAO khachHangDAO;

	@Override
	public List<Khachhang> findAll() {
		// TODO Auto-generated method stub
		return khachHangDAO.findAll();
	}
	
}
