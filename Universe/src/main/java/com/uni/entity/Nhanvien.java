package com.uni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "Phim")
public class Nhanvien implements Serializable{
	@Id
	String Manv;
	String Tennv;
	@JoinColumn(name = "Ngaysinh")
	@Temporal(TemporalType.DATE)
	Date Ngaysinh;
	String Sdt;
	String Matkhaunv;
	String Diachi;
	String Hinh;
	Boolean Vaitro;
}
