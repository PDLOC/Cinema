package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.VeDAO;
import com.uni.entity.Ve;
import com.uni.service.VeService;

@Service
public class VeServiceImpl implements VeService {
	@Autowired
	VeDAO veDAO;

	@Override
	public List<Ve> findAll() {
		// TODO Auto-generated method stub
		return veDAO.findAll();
	}

	@Override
	public List<Ve> findByMatk(String uname) {
		// TODO Auto-generated method stub
		return veDAO.findByMatk(uname);
	}
	
}
