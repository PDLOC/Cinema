package com.uni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Chitietphim")
public class Chitietphim implements Serializable{
	@Id
	String Mact;
	String Loaiphim;
	String Tenphim;
	@Column(name = "Khoichieu")
	@Temporal(TemporalType.DATE)
	Date Khoichieu;
	String Daodien;
	String Dienvien;
	String Noidung;
	String Linkytb;
	String Hinh;
	
	@ManyToOne
	@JoinColumn(name = "Mapc")
	Room room;
	
	@ManyToOne
	@JoinColumn(name = "Maphim")
	Phim film;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "ctphims")
	List<Lich> listlich;
}
