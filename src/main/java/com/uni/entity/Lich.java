package com.uni.entity;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
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
	Time Giobatdau;
	@JoinColumn(name = "Gioketthuc")	
	Time Gioketthuc;
	
	@ManyToOne
	@JoinColumn(name = "Mact")
	Chitietphim ctphims;

	public String getFormattedGiobatdau() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(Giobatdau);
    }
	public String getFormattedGioketthuc() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(Gioketthuc);
    }

}