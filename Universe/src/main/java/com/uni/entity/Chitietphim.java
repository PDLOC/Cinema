package com.uni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Chitietphim")
public class Chitietphim implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Stt;
	String Loaiphim;
	String Tenphim;
	@Column(name = "Ngaychieu")
	@Temporal(TemporalType.DATE)
	Date Ngaychieu;
	@Column(name = "Giochieu")
	@Temporal(TemporalType.TIME)
	Date Giochieu;
	String Daodien;
	String Dienvien;
	String Hinh;
	
	@ManyToOne
	@JoinColumn(name = "Mapc")
	Room room;
	
	@ManyToOne
	@JoinColumn(name = "Maphim")
	Phim film;
}
