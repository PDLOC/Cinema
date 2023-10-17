package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.PhimDAO;
import com.uni.entity.Film;
import com.uni.service.PhimService;

@Service
public class PhimServiceImpl implements PhimService {
	@Autowired
	PhimDAO pDao;

	@Override
	public List<Film> findAll() {
		// TODO Auto-generated method stub
		return pDao.findAll();
	}
	
}
