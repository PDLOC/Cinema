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
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

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
	@NotBlank(message = "* Không được để trống tài khoản")
	String username;
	@NotBlank(message = "* Không được để trống họ tên")
	String hoten;
	
	@NotBlank(message = "* Không được để trống email")
	@Email(message = "* Không đúng định dạng email")
	String email;
	
	@NotBlank(message = "* Không được để trống số điện thoại")
	@Length(min = 10, message = "* Số điện thoại không được ngắn hơn 10")
	@Length(max = 10, message = "* Số điện thoại không được dài hơn 10")
	String sdt;
	@NotNull(message = "* Không được để trống ngày sinh")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	Date ngaysinh;
	@NotBlank(message = "* Không được để trống mật khẩu")
	String password;
	String diachi;
	String hinh;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy = "taikhoan", fetch = FetchType.EAGER)
	List<Authority> authorities;

}
