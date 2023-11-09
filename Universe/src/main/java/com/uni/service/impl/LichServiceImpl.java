package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.LichDAO;
import com.uni.entity.Lich;
import com.uni.service.LichService;




@Service
public class LichServiceImpl implements LichService {
	@Autowired
	LichDAO lichDao;
	@Override
	public List<Lich> findAll() {
		// TODO Auto-generated method stub
		return lichDao.findAll();
	}
	@Override
	public Lich findById(Integer stt) {
		return lichDao.findById(stt).get();
	}
	
	@Override
	public Lich create(Lich lich) {
		return lichDao.save(lich);
	}
	@Override
	public Lich update(Lich lich) {
		return lichDao.save(lich);
	}

	@Override
	public void delete(Integer lich) {
		lichDao.deleteById(lich);
	}

}
