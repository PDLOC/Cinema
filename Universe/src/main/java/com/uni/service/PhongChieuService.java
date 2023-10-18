package com.uni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Room;

@Service
public interface PhongChieuService {

	List<Room> findAll();

}
