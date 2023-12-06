package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.ChitietphimDAO;
import com.uni.entity.Chitietphim;

import com.uni.service.ChitietphimService;

@Service
public class ChitietphimServiceImpl implements ChitietphimService {

	@Autowired
	ChitietphimDAO ctDAO;

	@Override
	public Chitietphim findById(String maCtphim) {
		
		return ctDAO.findById(maCtphim).get();
	}

	@Override
	public List<Chitietphim> findAll() {
		// TODO Auto-generated method stub
		return ctDAO.findAllChitietphim();
	}
	@Override
	public Chitietphim create(Chitietphim maCtphim) {
		return ctDAO.save(maCtphim);
	}
	@Override
	public Chitietphim update(Chitietphim maCtphim) {
		return ctDAO.save(maCtphim);
	}

	@Override
	public void delete(String maCtphim) {
		ctDAO.deleteById(maCtphim);
	}

	@Override
	public Chitietphim findByPhim(String maphim) {
		// TODO Auto-generated method stub
		return ctDAO.findByPhim(maphim);
	}

}
