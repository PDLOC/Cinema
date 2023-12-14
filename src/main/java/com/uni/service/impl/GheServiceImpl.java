package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.GheDAO;
import com.uni.entity.Ghe;
import com.uni.service.GheService;

@Service
public class GheServiceImpl implements GheService {
	@Autowired
	GheDAO gheDAO;

	@Override
	public List<Ghe> findAll() {
		// TODO Auto-generated method stub
		return gheDAO.findAll();
	}

	@Override
	public List<Ghe> findByMaphong(String mapc) {
		// TODO Auto-generated method stub
		return gheDAO.findByMaphong(mapc);
	}

	@Override
	public Ghe save(Ghe ghe) {
		// TODO Auto-generated method stub
		return gheDAO.save(ghe);
	}

	@Override
	public Ghe updateTrangthai(Ghe ghe) {
		// TODO Auto-generated method stub
		return gheDAO.save(ghe);
		
	}

	@Override
	public Ghe findById(Integer maghe) {
		// TODO Auto-generated method stub
		return gheDAO.findById(maghe).get();
	}

	@Override
	public Ghe findByTenGhe(String tenghe) {
		// TODO Auto-generated method stub
		return gheDAO.findByTenGhe(tenghe);
	}

	@Override
	public void delete(Integer maghe) {
		// TODO Auto-generated method stub
		gheDAO.deleteById(maghe);
	}

	@Override
	public Ghe create(Ghe ghe) {
		// TODO Auto-generated method stub
		return gheDAO.save(ghe);
	}

	@Override
	public Ghe update(Ghe ghe) {
		// TODO Auto-generated method stub
		return gheDAO.save(ghe);
	}

	@Override
	public Ghe findStatus(Integer maghe) {
		// TODO Auto-generated method stub
		return gheDAO.findStatus(maghe);
	}

}
