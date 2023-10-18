package com.uni.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.entity.Room;

public interface PhongChieuDAO extends JpaRepository<Room, Integer> {

}
