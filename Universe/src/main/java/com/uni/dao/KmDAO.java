package com.uni.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.entity.Khuyenmai;

public interface KmDAO extends JpaRepository<Khuyenmai, String> {

}
