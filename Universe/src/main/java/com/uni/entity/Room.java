package com.uni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Phong")
public class Room implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	Integer Mapc;
	String Tenpc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "room")
	List<Chitietphim> chitietphims;
}
