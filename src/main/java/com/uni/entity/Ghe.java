package com.uni.entity;

import java.io.Serializable;

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

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ghe")
public class Ghe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Maghe;
	String Tenghe;
	Integer Hang;
	Integer Cot;
	Boolean Trangthai;
	
	@ManyToOne
	@JoinColumn(name = "Phongchieuid")
	Room room;
	
	@OneToOne
	@JoinColumn(name = "Loaigheid")
	Loaighe loaighe;
}
