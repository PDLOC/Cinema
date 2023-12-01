package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.PhimDAO;
import com.uni.entity.Phim;
import com.uni.service.PhimService;

@Service
public class PhimServiceImpl implements PhimService {
	@Autowired
	PhimDAO pDao;

	@Override
	public List<Phim> findAll() {
		// TODO Auto-generated method stub
		return pDao.findAllPhim();
	}

	@Override
	public Phim findById(String maphim) {
		// TODO Auto-generated method stub
		if (maphim == null) {
			return null;
		}
		return pDao.findById(maphim).isPresent() ? pDao.findById(maphim).get() : null;
	}

	@Override
	public List<Phim> findPhimDangChieu() {
		// TODO Auto-generated method stub
		return pDao.findPhimDangChieu();
	}

	@Override
	public List<Phim> findPhimSapChieu() {
		// TODO Auto-generated method stub
		return pDao.findPhimSapChieu();
	}


	@Override
	public Phim create(Phim phim) {
		return pDao.save(phim);
	}
	@Override
	public Phim update(Phim phim) {
		return pDao.save(phim);
	}

	@Override
	public void delete(String phim) {
		pDao.deleteById(phim);
	}
	@Override
	public List<Object[]> top10phim() {
		return pDao.top10phim();
	}
	

	@Override
	public Long getTotalPhim() {
		return pDao.count();
	}

	
}
