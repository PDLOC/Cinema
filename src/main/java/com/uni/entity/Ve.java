package com.uni.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@JoinColumn(name = "Giobatdau")
	String giobatdau;
	
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
	
	@JsonIgnore
	public String getFormattedThanhtien() {
	    if (thanhtien != null) {
	        DecimalFormat decimalFormat = new DecimalFormat("#.### VNĐ");
	        return decimalFormat.format(thanhtien);
	    }
	    return ""; // hoặc giá trị mặc định khác tùy thuộc vào yêu cầu của bạn
	}

	@JsonIgnore
	public String getFormattedNgaygiaodich() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(ngaygiaodich);
	}

	@JsonIgnore
	public String getFormattedNgaychieu() {
	    if (ngaychieu != null) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        return formatter.format(ngaychieu.toInstant());
	    }
	    return "";
	}

}
