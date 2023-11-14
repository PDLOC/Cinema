package com.uni.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.dao.TaiKhoanDAO;

import com.uni.entity.Taikhoan;
import com.uni.service.TaikhoanService;

@Service
public class TaikhoanServiceImpl implements TaikhoanService {
	@Autowired
	TaiKhoanDAO taiKhoanDAO;

	@Override
	public List<Taikhoan> findAll() {
		// TODO Auto-generated method stub
		return taiKhoanDAO.findAll();
	}

	@Override
	public Taikhoan create(Taikhoan tk) {
		return taiKhoanDAO.save(tk);
	}

	@Override
	public Taikhoan update(Taikhoan tk) {
		return taiKhoanDAO.save(tk);
	}


	@Override
	public void delete(String username) {
		taiKhoanDAO.deleteById(username);
	}

	@Override
	public Taikhoan findById(String matk) {
		// TODO Auto-generated method stub
		// return taiKhoanDAO.findById(matk).get();
		if (matk == null) {
			return null;
		}
		return taiKhoanDAO.findById(matk).isPresent() ? taiKhoanDAO.findById(matk).get() : null;
	}

//	@Override
//	public Taikhoan findById(String matk) {
//	    Optional<Taikhoan> optionalTaikhoan = taiKhoanDAO.findById(matk);
//	    if (optionalTaikhoan.isPresent()) {
//	        return optionalTaikhoan.get();
//	    } else {
//	        // Xử lý khi không tìm thấy giá trị
//	        throw new RuntimeException("Không tìm thấy tài khoản với mã: " + matk);
//	    }
//	}

	@Override
	public List<Taikhoan> getAdministrators() {
		// TODO Auto-generated method stub
		return taiKhoanDAO.getAdministrators();
	}

	@Override
	public List<Taikhoan> findStaffAndAd() {
		// TODO Auto-generated method stub
		return taiKhoanDAO.findStaffandAd();
	}

	@Override
	public Long getTotalTK() {
		return taiKhoanDAO.count();
	}
	@Override
	public List<Object[]> top10Customer() {
		return taiKhoanDAO.top10Customer();
	}
}
