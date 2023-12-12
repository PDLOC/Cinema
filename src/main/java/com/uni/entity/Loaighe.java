package com.uni.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "LGhe")
public class Loaighe implements Serializable{
	@Id
	String Maloai;
	String Tenloaighe;
	Integer Dongia;
	
	public Loaighe(String maloai) {
		this.Maloai = maloai;
	}
}
