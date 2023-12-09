package com.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uni.dao.TaiKhoanDAO;
import com.uni.entity.Taikhoan;
import com.uni.service.TaikhoanService;
import com.uni.service.impl.MailerServiceImpl;

import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("home")
public class ForgetPasswordController {
	@Autowired
	TaiKhoanDAO accountDao;

	@Autowired
	MailerServiceImpl mailer;
	
	@Autowired
	TaikhoanService taikhoanService;


	@RequestMapping("forget-pass")
	public String forgetpass(Model model,@RequestParam("matk") String username,@RequestParam("email") String email) {
		String subject = "Send your Password!";
		String randomPassword = RandomString.make(6);
		String imageUrl = "https://res.cloudinary.com/denbzrony/image/upload/v1702100071/ipweqzcmyymygwqdwhxb.png";
		String body = "<html>" +
                "<head>" +
                "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">" +
                "<style>" +
                "   h1{" +
                "       color: red;" +
                "   }" +
                "   b{" +
                "       color: #30A2FF;" +
                "       font-size: 22px;" +
                "   }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"container\">" +
                "<h1>Universe Cinema</h1>"+
                "<p>Chào bạn</p>"+
                "Bạn đã đươc cấp mật khẩu mới: <b>"+randomPassword+"</b>"+
                "<p>Vui lòng hoàn thành xác nhận trong vòng 30 phút.</p>"+
                "<p><small>Đây là thư từ hệ thống, vui lòng không trả lời thư.</small></p>"+
                "</div>" +
                "<img src='" + imageUrl + "' alt='Hình ảnh'>"+
                "</body>" +
                "</html>";		
		try {
			Taikhoan acc = accountDao.findById(username).get();
			System.out.println("" + acc);
			if (acc.getEmail().equals(email)) {
				acc.setMatkhau(randomPassword);
				taikhoanService.update(acc);
				mailer.send(email, subject, body);
				model.addAttribute("message", "Gửi thành công ! Vui lòng kiểm tra Email !");
			} else {
				model.addAttribute("message", "Sai Email !");
			}
		} catch (Exception e) {
			model.addAttribute("message", "Tài khoản không hợp lệ !");
		}
		return "home/register_login/login";
	}
}
