package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Ve;

@Service
public interface VeService {


	List<Ve> findAll();

	List<Ve> findByMatk(String uname);
	List<Object[]> getRevenueLast7Days();

	Long getToDayVe();

	Long totalVe();

	Double getTodayIncome();

	Double getTotalIncome();

	Ve create(Ve ve);

}
