package com.uni.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ghe")
public class Ghe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Maghe;
	String Tenghe;
	Integer Hang;
	Integer Cot;
	Boolean Trangthai;
	
	@JsonDeserialize(using = PhongchieuDeserializer.class)
	@ManyToOne
	@JoinColumn(name = "Phongchieuid")
	Room room;
	
	@JsonDeserialize(using = LoaigheDeserializer.class)
	@OneToOne
	@JoinColumn(name = "Loaigheid")
	Loaighe loaighe;
}
