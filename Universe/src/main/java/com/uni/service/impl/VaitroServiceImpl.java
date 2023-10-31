package com.uni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.VaitroDAO;
import com.uni.service.VaitroService;

@Service
public class VaitroServiceImpl implements VaitroService{
	@Autowired
	VaitroDAO vaitroDAO;
}
