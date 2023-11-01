package com.uni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "Taikhoan")
public class TaiKhoan implements Serializable{
	@Id
	String Matk;
	String Hoten;
	String Email;
	String Sdt;
	@Temporal(TemporalType.DATE)
	Date Ngaysinh;
	String Matkhau;
	String Diachi;
	String Hinh;
	
	@OneToOne
	@JoinColumn(name = "Mavaitro")
	Vaitro vaitro;

}
