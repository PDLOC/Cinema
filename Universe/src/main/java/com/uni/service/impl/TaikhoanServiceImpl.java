package com.uni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.TaiKhoanDAO;
import com.uni.entity.TaiKhoan;
import com.uni.service.TaikhoanService;

@Service
public class TaikhoanServiceImpl implements TaikhoanService{
	@Autowired
	TaiKhoanDAO taiKhoanDAO;

	@Override
	public TaiKhoan findById(String username) {
		// TODO Auto-generated method stub
		return taiKhoanDAO.findById(username).get();
	}
	
	
}
