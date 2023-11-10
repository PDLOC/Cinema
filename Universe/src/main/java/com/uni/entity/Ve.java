package com.uni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ve")
public class Ve implements Serializable{
	@Id
	String mave;
	String tenphim;
	String combo;
	@Temporal(TemporalType.DATE)
	Date ngaychieu;
	@Temporal(TemporalType.TIME)
	Date giobatdau;
	String ghe;
	Integer soluong;
	Integer giamgia;
	Double thanhtien;
	Boolean trangthai;
	
	@ManyToOne
	@JoinColumn(name = "Matk")
	Taikhoan taikhoan;
	
	@OneToOne
	@JoinColumn(name = "Lichstt")
	Lich lich;
	
}
