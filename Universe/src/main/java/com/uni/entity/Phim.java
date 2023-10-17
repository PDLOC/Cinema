package com.uni.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Phim")
public class Phim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Maphim;
	private String Tenphim;
	@Temporal(TemporalType.TIMESTAMP)
	private Date Suatchieu;
	private String Daodien;
	private String Dienvien;
	private Integer Thoiluong;
	private Integer Namsx;
	private String Hinh;
	
	@OneToOne
	@JoinColumn(name = "Mapc")
	private PhongChieu phongChieu;
	@JsonIgnore
	@OneToMany(mappedBy = "Malp")
	private List<LoaiPhim> loaiPhim;
}
