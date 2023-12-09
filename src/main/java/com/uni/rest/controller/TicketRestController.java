package com.uni.rest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketRestController {
	
	@PostMapping("/api/session")
	  public void receiveSessionValue(@RequestBody SessionValueDto sessionValueDto, HttpSession session) {
	    String sessionValue = (String)session.getAttribute("tenphim"); // Lấy giá trị session từ yêu cầu
	    
	    System.out.print(sessionValue);
	    
	    // Sử dụng giá trị session theo nhu cầu của bạn
	    // Ví dụ: Lưu giá trị session vào session trong Java
	    session.setAttribute("sessionValue", sessionValue);
	  }
}

	
