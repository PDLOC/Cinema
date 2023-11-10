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

}
