package com.uni.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.entity.Nhanvien;

public interface NhanVienDAO extends JpaRepository<Nhanvien, String> {

}
