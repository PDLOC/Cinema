package com.uni.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "Khachhang")
public class Khachhang {
	@Id
	String Makh;
	String Tenkh;
	String Email;
	String Sdt;
	@Temporal(TemporalType.DATE)
	Date Ngaysinh;
	String Matkhaukh;
	String Hinh;
}
