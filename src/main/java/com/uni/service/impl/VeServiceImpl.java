package com.uni.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.VeDAO;
import com.uni.entity.Ve;
import com.uni.service.VeService;
import com.uni.service.XDate;

@Service
public class VeServiceImpl implements VeService {
	@Autowired
	VeDAO veDAO;
	@Autowired 
	private XDate xdate;
	@Override
	public List<Ve> findAll() {
		// TODO Auto-generated method stub
		return veDAO.findAllVeByDescending();
	}

	@Override
	public List<Ve> findByMatk(String uname) {
		// TODO Auto-generated method stub
		return veDAO.findByMatk(uname);
	}
	
	@Override
	public Long getToDayVe() {
		return veDAO.getTodayVe();
	}
	@Override
	public Long totalVe() {
		return veDAO.count();
	}
	
	@Override
	public List<Object[]> getRevenueLast7Days() {
		return veDAO.getRevenueLast7Days();
	}
	
	@Override
	public Double getTodayIncome() {
		return veDAO.findAll().stream().filter(e->e.getNgaygiaodich().toString().equals(xdate.convertToPattern(new Date(), "yyyy-MM-dd"))).mapToDouble(item->item.getThanhtien()).sum();
	}
	
	@Override
	public Double getTotalIncome() {
		return veDAO.findAll().stream().mapToDouble(item->item.getThanhtien()).sum();
	}

	@Override
	public Ve create(Ve ve) {
		// TODO Auto-generated method stub
		return veDAO.save(ve);
	}

}
