package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.PhongChieuDAO;
import com.uni.entity.Room;
import com.uni.service.PhongChieuService;


@Service
public class PhongChieuServiceImpl implements PhongChieuService{
	@Autowired
	PhongChieuDAO pcDAO;
	
	
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return pcDAO.findAll();
	}

}
