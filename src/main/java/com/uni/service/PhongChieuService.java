package com.uni.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.uni.entity.Phim;
import com.uni.entity.Room;

@Service
public interface PhongChieuService {

	List<Room> findAll();

	Room create(Room room);

	Room update(Room room);

	void delete(String id);

	Room findById(String mapc);

	List<Room> findAllDesc();

	
}
