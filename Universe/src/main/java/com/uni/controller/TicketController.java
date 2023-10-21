package com.uni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class TicketController {
	@RequestMapping("booking/ticket")
	public String ticket(Model model) {
		
		return "home/seat/bookseat";
	}
}
