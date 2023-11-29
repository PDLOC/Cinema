package com.uni.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	String makm;
	@Temporal(TemporalType.DATE)
	@JoinColumn(name = "Ngaychieu")
	Date ngaychieu;
	@Temporal(TemporalType.TIME)
	@JoinColumn(name = "Giobatdau")
	Date giobatdau;
	@Temporal(TemporalType.TIME)
	@JoinColumn(name = "Gioketthuc")
	Date gioketthuc;
	@Temporal(TemporalType.DATE)
	@JoinColumn(name = "Ngaygiaodich")
	Date ngaygiaodich;
	String ghe;
	Integer soluong;
	Integer giamgia;
	Double thanhtien;
	String hinh;
	Boolean trangthai;

	@ManyToOne
	@JoinColumn(name = "Matk")
	Taikhoan taikhoan;

	@OneToOne
	@JoinColumn(name = "Lichstt")
	Lich lich;

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

	public String getFormattedGioketthuc() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(gioketthuc);
	}

}
