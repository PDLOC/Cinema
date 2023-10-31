package com.uni.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Setter @Getter
@Table(name = "Vaitro")
public class Vaitro {
	@Id
	String Mavaitro;
	String Tenvaitro;
}
