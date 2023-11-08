package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Chitietkm;
import com.uni.entity.Khuyenmai;

@Service
public interface ChitietkmService {

	Chitietkm findByMa(String makm);

	List<Chitietkm> findAll();

	Chitietkm findById(Integer stt);

	Chitietkm create(Chitietkm ctkm);

	Chitietkm update(Chitietkm ctkm);

	void delete(Integer stt);


}
