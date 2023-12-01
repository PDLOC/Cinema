package com.uni.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ve")
public class Ve implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer mave;
	String tenphim;
	String combo;
	String tenpc;
	
	@Temporal(TemporalType.DATE)
	@JoinColumn(name = "Ngaychieu")
	Date ngaychieu;
	
	@JsonFormat(shape = Shape.STRING , pattern="HH:mm:ss", timezone="CET")
	@Temporal(TemporalType.TIME)
	@JoinColumn(name = "Giobatdau")
	Date giobatdau;
	
	@Temporal(TemporalType.DATE)
	@JoinColumn(name = "Ngaygiaodich")
	Date ngaygiaodich = new Date();
	String ghe;
	Integer soluong;
	Integer giamgia;
	Double thanhtien;
	String hinh;
	Boolean trangthai;

	@JsonDeserialize(using = TaikhoanDeserializer.class)
	@ManyToOne
	@JoinColumn(name = "Matk")
	Taikhoan taikhoan;

	@JsonDeserialize(using = LichDeserializer.class)
	@OneToOne
	@JoinColumn(name = "Lichstt")
	Lich lich;

	@JsonDeserialize(using = KhuyenmaiDeserializer.class)
	@OneToOne
	@JoinColumn(name = "Makm")
	Khuyenmai khuyenmai;
	
	public String getFormattedThanhtien() {
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		return decimalFormat.format(thanhtien);
	}

	public String getFormattedNgaygiaodich() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(ngaygiaodich);
	}

	public String getFormattedNgaychieu() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(ngaychieu);
	}

	public String getFormattedGiobatdau() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(giobatdau);
	}


}
