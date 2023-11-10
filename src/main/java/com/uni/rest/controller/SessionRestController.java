package com.uni.rest.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.entity.Taikhoan;
import com.uni.service.SessionService;
import com.uni.service.TaikhoanService;

@RestController
@RequestMapping("/api")
public class SessionRestController {
	@Autowired
	SessionService sessionService;
	@Autowired
	TaikhoanService taikhoanService;

	@GetMapping("/session")
	public Map<String, Object> getSessionData(Principal principal) {
		Map<String, Object> sessionData = new HashMap<>();;
		// Tìm qua spring security
		if (principal != null) {
			Authentication authentication = (Authentication) principal;
			User user = (User) authentication.getPrincipal();
			Taikhoan taikhoan = taikhoanService.findById(user.getUsername());
			sessionService.set("login", taikhoan);
			// System.out.println(""+sessionService.get("login"));
			sessionService.set("username", taikhoan.getHoten());
			sessionService.set("profileImage", taikhoan.getHinh());
			sessionData.put("username", sessionService.get("username"));
			sessionData.put("profileImage", sessionService.get("profileImage"));
		} else {
			sessionService.remove("login");
			sessionService.remove("username");
			sessionService.remove("profileImage");
		}
		return sessionData;
	}
}
