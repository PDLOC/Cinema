package com.uni.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment implements Serializable {
	private Integer status;
	private String message;
	private String url;
}
