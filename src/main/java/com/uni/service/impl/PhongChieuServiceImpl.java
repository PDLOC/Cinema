package com.uni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.PhongChieuDAO;
import com.uni.entity.Room;
import com.uni.entity.Taikhoan;
import com.uni.service.PhongChieuService;


@Service
public class PhongChieuServiceImpl implements PhongChieuService{
	@Autowired
	PhongChieuDAO pcDAO;
	
	
	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return pcDAO.findAll();
	}


	@Override
	public Room create(Room room) {
		// TODO Auto-generated method stub
		return pcDAO.save(room);
	}


	@Override
	public Room update(Room room) {
		// TODO Auto-generated method stub
		return pcDAO.save(room);
	}


	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		pcDAO.deleteById(id);;
	}
	
	@Override
	public Room findById(String mapc) {
		// TODO Auto-generated method stub
		// return taiKhoanDAO.findById(matk).get();
		if (mapc == null) {
			return null;
		}
		return pcDAO.findById(mapc).isPresent() ? pcDAO.findById(mapc).get() : null;
	}


	@Override
	public List<Room> findAllDesc() {
		// TODO Auto-generated method stub
		return pcDAO.findAllVeByDescending();
	}

}
