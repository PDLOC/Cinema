package com.uni.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uni.entity.Lich;

@Service
public interface LichService {

	List<Lich> findAll();

	Lich findById(Integer stt);

	Lich create(Lich lich);

	Lich update(Lich lich);

	void delete(Integer lich);

	List<Date> findByMact(String mact);

	List<Lich> findByMatct(String mact);

}
