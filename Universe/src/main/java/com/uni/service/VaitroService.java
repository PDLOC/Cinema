package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Vaitro;

@Service
public interface VaitroService {

	List<Vaitro> findAll();

}
