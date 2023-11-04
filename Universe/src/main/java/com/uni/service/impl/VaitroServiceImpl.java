package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.VaitroDAO;
import com.uni.entity.Vaitro;
import com.uni.service.VaitroService;

@Service
public class VaitroServiceImpl implements VaitroService{
	@Autowired
	VaitroDAO vaitroDAO;

	@Override
	public List<Vaitro> findAll() {
		// TODO Auto-generated method stub
		return vaitroDAO.findAll();
	}
}
