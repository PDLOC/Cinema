package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Khuyenmai;

@Service
public interface KmService {

	List<Khuyenmai> findAll();

	Khuyenmai findById(String makm);

	Khuyenmai create(Khuyenmai km);

	Khuyenmai update(Khuyenmai km);

	void delete(String makm);

	List<Khuyenmai> findAllExcept();

}
