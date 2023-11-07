package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.AuthorityDAO;
import com.uni.entity.Authority;
import com.uni.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthorityDAO authorityDAO;
	
	
	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityDAO.findAll();
	}


	@Override
	public List<Authority> getOneByRole(String username) {
		// TODO Auto-generated method stub
		return authorityDAO.getOneByRole(username);
	}
	
}
