package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Ghe;
import com.uni.entity.Loaighe;

@Service
public interface LoaiGheService {
	
	List<Loaighe> findAll();

	Loaighe findById(String maloai);

	Loaighe update(Loaighe loaighe);

	void delete(String maghe);

	Loaighe save(Loaighe loaighe);


	
}
