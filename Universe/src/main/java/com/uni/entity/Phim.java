package com.uni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "Phim")
public class Phim implements Serializable {
	@Id
	String Maphim;	
	String Tenphim;
	String Thoiluong;
	Integer Namsx;
	String Hinh;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "film")
	List<Chitietphim> ctPhims;
	
	@OneToOne
	@JoinColumn(name = "Matrangthai")
	Trangthai trangthai;
}
