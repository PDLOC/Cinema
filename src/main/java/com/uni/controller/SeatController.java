package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class SeatController {
	@RequestMapping("seat")
	public String seat() {
		
		return "home/seat/bookseat.html";
	}
}