package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.entity.Loaighe;
import com.uni.service.LoaiGheService;
import com.uni.dao.LoaigheDAO;

@Service
public class LoaiGheServiceImpl implements LoaiGheService {
	
	@Autowired
	LoaigheDAO Lghedao;
	
	@Override
	public List<Loaighe> findAll() {
		return Lghedao.findAll();
	}

	@Override
	public Loaighe findById(String maloai) {
		// TODO Auto-generated method stub
		return Lghedao.findById(maloai).get();
	}

	@Override
	public Loaighe update(Loaighe loaighe) {
		// TODO Auto-generated method stub
		return Lghedao.save(null);
	}

	@Override
	public void delete(String maghe) {
		// TODO Auto-generated method stub
		Lghedao.deleteById(maghe);
	}

	@Override
	public Loaighe save(Loaighe loaighe) {
		// TODO Auto-generated method stub
		return Lghedao.save(loaighe);
	}


}
