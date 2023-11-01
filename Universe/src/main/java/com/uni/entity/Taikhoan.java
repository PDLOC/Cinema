package com.uni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Taikhoan")
public class Taikhoan implements Serializable{
	@Id
	String username;
	String hoten;
	String email;
	String sdt;
	@Temporal(TemporalType.DATE)
	Date ngaysinh;
	String password;
	String diachi;
	String hinh;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "taikhoan", fetch = FetchType.EAGER)
	List<Authority> authorities;

}
