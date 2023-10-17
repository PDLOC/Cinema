package com.uni.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uni.entity.Film;

public interface PhimDAO extends JpaRepository<Film, Integer> {

}
