package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.AuthorityDAO;
import com.uni.entity.Phanquyen;
import com.uni.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthorityDAO authorityDAO;
	
	
	@Override
	public List<Phanquyen> findAll() {
		// TODO Auto-generated method stub
		return authorityDAO.findAll();
	}


	@Override
	public List<Phanquyen> getOneByRole(String username) {
		// TODO Auto-generated method stub
		return authorityDAO.getOneByRole(username);
	}
	
	/*Summary*/
	@Override
	public Long getTotalCustomer() {
		return authorityDAO.findAll().stream().filter(e->e.getVaitro().getTenvaitro().equals("Khách hàng")).count();
	}


	@Override
	public Phanquyen create(Phanquyen phanquyen) {
		// TODO Auto-generated method stub
		return authorityDAO.save(phanquyen);
	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		authorityDAO.deleteById(id);
	}


	@Override
	public void deleteByUsername(String username) {
		// TODO Auto-generated method stub
		authorityDAO.deleteByUserName(username);
	}
	
}
