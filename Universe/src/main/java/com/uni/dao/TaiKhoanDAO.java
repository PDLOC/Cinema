package com.uni.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.entity.TaiKhoan;

public interface TaiKhoanDAO extends JpaRepository<TaiKhoan, String> {

}
