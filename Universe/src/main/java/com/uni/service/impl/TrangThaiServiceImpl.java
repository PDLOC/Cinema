package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.TrangThaiDAO;
import com.uni.entity.Trangthai;
import com.uni.service.TrangThaiService;

@Service
public class TrangThaiServiceImpl implements TrangThaiService {
	@Autowired
	TrangThaiDAO trangThaiDAO;
	@Override
	public List<Trangthai> findAll() {
		// TODO Auto-generated method stub
		return trangThaiDAO.findAll();
	}
	

}
