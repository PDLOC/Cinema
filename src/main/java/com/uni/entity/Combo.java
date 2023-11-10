package com.uni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "Combo")
public class Combo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	Integer Stt;
	String Macb;
	String Tencb;
	String Mota;
	Integer Soluong;
    Double Dongia;
    String Hinh;
    
}
