package com.uni.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Table(name = "Vaitro")
public class Vaitro{
	@Id
	String Mavaitro;
	String Tenvaitro;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "vaitro")
	List<Phanquyen> authorities;
}
