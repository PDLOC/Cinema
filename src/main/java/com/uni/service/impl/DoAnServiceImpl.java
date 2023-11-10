package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.DoAnDAO;
import com.uni.entity.Doan;

import com.uni.service.DoAnService;

@Service
public class DoAnServiceImpl implements DoAnService {
	@Autowired
	DoAnDAO doandao;
	@Override
	public List<Doan> findAll() {
		// TODO Auto-generated method stub
		return doandao.findAll();
	}
	@Override
	public Doan findById(Integer madoan) {
		return doandao.findById(madoan).get();
	}
	
	@Override
	public Doan create(Doan doan) {
		return doandao.save(doan);
	}
	@Override
	public Doan update(Doan doan) {
		return doandao.save(doan);
	}

	@Override
	public void delete(Integer doan) {
		doandao.deleteById(doan);
	}

}
