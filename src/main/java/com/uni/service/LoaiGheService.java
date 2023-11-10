package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.uni.entity.Loaighe;

@Service
public interface LoaiGheService {
	
	List<Loaighe> findAll();
	
}
