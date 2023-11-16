package com.uni.controller;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO implements Serializable {
	
	private String status;
	private String message;
	private String URL;
	
}
