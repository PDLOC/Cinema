package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.KmDAO;
import com.uni.entity.Khuyenmai;
import com.uni.service.KmService;

@Service
public class KmServiceImpl implements KmService{
	@Autowired
	KmDAO kmDAO;

	@Override
	public List<Khuyenmai> findAll() {
		// TODO Auto-generated method stub
		return kmDAO.findAllKhuyenmaiByDescending();
	}

	@Override
	public Khuyenmai findById(String makm) {
		// TODO Auto-generated method stub
		if (makm == null) {
			return null;
		}
		return kmDAO.findById(makm).isPresent() ? kmDAO.findById(makm).get() : null;
	}

	@Override
	public Khuyenmai create(Khuyenmai km) {
		// TODO Auto-generated method stub
		return kmDAO.save(km);
	}

	@Override
	public Khuyenmai update(Khuyenmai km) {
		// TODO Auto-generated method stub
		return kmDAO.save(km);
	}

	@Override
	public void delete(String makm) {
		// TODO Auto-generated method stub
		kmDAO.deleteById(makm);
	}

	@Override
	public List<Khuyenmai> findAllExcept() {
		// TODO Auto-generated method stub
		return kmDAO.findAllExcept();
	}
	
}
