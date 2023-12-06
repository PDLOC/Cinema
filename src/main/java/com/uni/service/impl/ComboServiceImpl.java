package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.ComboDAO;
import com.uni.entity.Combo;
import com.uni.service.ComboService;


@Service
public class ComboServiceImpl implements ComboService {
	@Autowired
	ComboDAO combodao;
	@Override
	public List<Combo> findAll() {
		// TODO Auto-generated method stub
		return combodao.findAllComboByDescending();
	}
	@Override
	public Combo findById(Integer stt) {
		return combodao.findById(stt).get();
	}
	
	@Override
	public Combo create(Combo combo) {
		return combodao.save(combo);
	}
	@Override
	public Combo update(Combo combo) {
		return combodao.save(combo);
	}

	@Override
	public void delete(Integer combo) {
		combodao.deleteById(combo);
	}

}
