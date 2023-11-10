package com.uni.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "Chitietkm")
public class Chitietkm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String mota;
	
	@OneToOne
	@JoinColumn(name = "Makm")
	Khuyenmai khuyenmai;
	
}
