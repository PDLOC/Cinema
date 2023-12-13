package com.uni.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("home")
public class ContactController {
	@Autowired
	JavaMailSender mailer;

	@RequestMapping("contact")
	public String contact() {
		
		return "home/contact/contact";
	}
	
	@RequestMapping("send")
	public String send(ModelMap model, 
			@RequestParam("from") String from,
			@RequestParam("subject") String subject,
			@RequestParam("body") String body) {
		try{
			// Tạo mail
			String to = "alexred20151@gmail.com";
			MimeMessage mail =mailer.createMimeMessage();
			// Sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);

			// Gửi mail
			mailer.send(mail);
			
			model.addAttribute("message", "Gửi email thành công !");
		}
		catch(Exception ex){
			model.addAttribute("message", "Gửi email thất bại !");
		}
		return "home/contact/contact";
	}
}
