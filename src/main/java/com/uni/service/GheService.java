package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Ghe;

@Service
public interface GheService {

	List<Ghe> findAll();

	List<Ghe> findByMaphong(String mapc);

	Ghe save(Ghe ghe);

	Ghe findByTenGhe(String seatName);

	Ghe updateTrangthai(Ghe ghe);

	Ghe findById(Integer maghe);

	void delete(Integer maghe);

	Ghe create(Ghe ghe);

	Ghe update(Ghe ghe);

	Ghe findStatus(Integer maghe);

}
