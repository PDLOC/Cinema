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
@Table(name = "Khuyenmai")
public class Khuyenmai {
	@Id
	String makm;
	String tenkm;
	Double giamgia;
	@Temporal(TemporalType.DATE)
	Date ngaybatdau;
	@Temporal(TemporalType.DATE)
	Date ngayketthuc;
	String hinh;
	
	
}
