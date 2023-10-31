package com.uni.service.impl;

import java.util.List;

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
	
	
	@Override
	public List<TaiKhoan> findAll() {
		// TODO Auto-generated method stub
		return taiKhoanDAO.findAll();
	}

	
	@Override
	public TaiKhoan create(TaiKhoan tk) {
		return taiKhoanDAO.save(tk);
	}
	@Override
	public TaiKhoan update(TaiKhoan tk) {
		return taiKhoanDAO.save(tk);
	}

	@Override
	public void delete(String username) {
		taiKhoanDAO.deleteById(username);
	}
}
