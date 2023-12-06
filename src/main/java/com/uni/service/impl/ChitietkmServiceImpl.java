package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.ChitietkmDAO;
import com.uni.entity.Chitietkm;
import com.uni.service.ChitietkmService;

@Service
public class ChitietkmServiceImpl implements ChitietkmService{
	@Autowired
	ChitietkmDAO chitietkmDAO;

	@Override
	public Chitietkm findByMa(String makm) {
		// TODO Auto-generated method stub
		return chitietkmDAO.findByMa(makm);
	}

	@Override
	public List<Chitietkm> findAll() {
		// TODO Auto-generated method stub
		return chitietkmDAO.findAllChitietkmByDescending();
	}

	@Override
	public Chitietkm findById(Integer id) {
		// TODO Auto-generated method stub
		return chitietkmDAO.findById(id).get();
	}

	@Override
	public Chitietkm create(Chitietkm ctkm) {
		// TODO Auto-generated method stub
		return chitietkmDAO.save(ctkm);
	}

	@Override
	public Chitietkm update(Chitietkm ctkm) {
		// TODO Auto-generated method stub
		return chitietkmDAO.save(ctkm);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		chitietkmDAO.deleteById(id);
	}
	
	
}
