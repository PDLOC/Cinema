package com.uni.service.impl;

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
	public Chitietphim findById(String maphim) {
		// TODO Auto-generated method stub
		return ctDAO.findByMaphim(maphim);
	}

}
