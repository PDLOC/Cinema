package com.uni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Lich")
public class Lich implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Stt;
	@JoinColumn(name = "Ngaychieu")
	@Temporal(TemporalType.DATE)
	Date Ngaychieu;
	@JoinColumn(name = "Giobatdau")
	@Temporal(TemporalType.TIME)
	Date Giobatdau;
	@JoinColumn(name = "Gioketthuc")
	@Temporal(TemporalType.TIME)
	Date Gioketthuc;
	
	@ManyToOne
	@JoinColumn(name = "Mact")
	Chitietphim ctphims;
}