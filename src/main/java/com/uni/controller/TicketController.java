package com.uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.uni.controller.PaymentController;
import com.uni.dao.TaiKhoanDAO;
import com.uni.service.ChitietphimService;
import com.uni.entity.Chitietphim;
import com.uni.entity.Lich;
import com.uni.entity.Loaighe;
import com.uni.entity.Taikhoan;
import com.uni.entity.Combo;
import com.uni.entity.Ghe;
import com.uni.entity.Khuyenmai;
import com.uni.service.KmService;
import com.uni.service.LoaiGheService;
import com.uni.service.SessionService;
import com.uni.service.impl.MailerServiceImpl;
import com.uni.service.ComboService;
import com.uni.service.GheService;

@Controller
@RequestMapping("home")
public class TicketController {
	
	@Autowired
	ChitietphimService CtphimService;
	
	@Autowired
	TaiKhoanDAO accountDao;
	
	@Autowired
	KmService khuyenMaiService;
	
	@Autowired 
	LoaiGheService LgheService;
	
	@Autowired
	GheService gheService;
	
	@Autowired
	ComboService comboService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	MailerServiceImpl mailer;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("booking/ticket/{mapc}/{mact}/{gioBatDau}")
	public String ticket(Model model,@PathVariable("mapc") String mapc,@PathVariable("mact") String mact,@PathVariable("gioBatDau") String Giobatdau) {
		Chitietphim CtPhim = CtphimService.findById(mact);
		//Hiển thị Giờ bắt đầu và Giờ kết thúc
		for (Lich L : CtPhim.getListlich()) {
			if (L.getGiobatdau().toString().contains(Giobatdau)) {
				model.addAttribute("itemL",L);
				System.out.println(L.getStt());
			}
		}
		model.addAttribute("itemCt",CtPhim);
		
		//loaiGhe
		List<Loaighe> Lghe = LgheService.findAll();
		model.addAttribute("itemLGhe",Lghe);
		
		//comBo
		List<Combo> combo = comboService.findAll();
		model.addAttribute("itemComBo",combo);
		
		//khuyen mai		
		List<Khuyenmai> km = khuyenMaiService.findAll();
		model.addAttribute("itemKM",km);
		
		//Ghế
		List<Ghe> ghe = gheService.findByMaphong(mapc);
		model.addAttribute("listGhe",ghe);
		
		return "home/seat/bookseat";
	}
	
	
	@RequestMapping("booking/ticket/pay/{totalPay}")
	public String payment(@PathVariable("totalPay") long totalpay) {
		PaymentController pc = new PaymentController();
		String urlpay = null;
		try {
			urlpay = pc.payment(totalpay);
		} catch (Exception e) {
			System.out.print(e);
		}
		return "redirect:"+urlpay;
	}
	
	@RequestMapping("booking/SendBill/{username}/{nameMovie}/{timeMovie}/{dateMovie}/{seatPositionElement.textContent}/{room}/{totalAmount}")
	public String sendMail(@PathVariable("username") String username,
	                       @PathVariable("nameMovie") String nameMovie,
	                       @PathVariable("timeMovie") String timeMovie,
	                       @PathVariable("dateMovie") String dateMovie,
	                       @PathVariable("seatPositionElement.textContent") String ghe,
	                       @PathVariable("room") String room,
	                       @PathVariable("totalAmount") String thanhtien) {
	    try {
	        if (username != null) {
	            Taikhoan acc = accountDao.findById(username).get();
	    		String imageUrl = "https://res.cloudinary.com/denbzrony/image/upload/v1702100071/ipweqzcmyymygwqdwhxb.png";
	            String subject = "Thông Tin Vé";
	            String content = "<!DOCTYPE html>"+
	           " <html >"+

	           " <head>"+
	               
"<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">" +
	               " <title>Thông tin vé</title>"+
	          "  </head>"+

	          "  <body>"+
	             "   <div class=\"container\">"+
	              "      <h1 class=\"text-center mt-5\">Thông tin vé</h1>"+
	                 "   <div class=\"row mt-5\">"+
	                  "      <div class=\"col-md-4\">"+
	                  "          <h4>Mã vé</h4>"+
	                  "          <p>955220968</p>"+
	                     "   </div>"+
	                     "   <div class=\"col-md-4\">"+
	                      "      <h4>Tên phim :</h4> <p>"+ nameMovie+"</p>"+
	                      "  </div>"+
	                      "  <div class=\"col-md-4\">"+
	                       "     <h4>Rap</h4>"+
	                        "    <p>Universe Cinema</p>"+
	                      "  </div>"+
	                   " </div>"+
	                  "  <div class=\"row mt-5\">"+
	                    "    <div class=\"col-md-4\">"+
	                    "        <h4>Phòng chiếu</h4>"+
	                     "       <p>"+room+"</p>"+
	                    "    </div>"+
	                     "   <div class=\"col-md-4\">"+
	                      "      <h4>Suất chiếu</h4>"+
	                       "     <p>"+dateMovie+"_" +timeMovie+ "</p>"+
	                        "</div>"+
	                        "<div class=\"col-md-4\">"+
	                         "   <h4>Ghế</h4>"+
	                          "  <p>"+ghe+"</p>"+
	                        "</div>"+
	                    "</div>"+
	                    "<div class=\"row mt-5\">"+
	                    
	                      
	                        "<div class=\"col-md-4\">"+
	                         "   <h4>Tổng cộng</h4>"+
	                          "  <p>"+thanhtien+"</p>"+
	                        "</div>"+
	                    "</div>"+
	                  
	                "</div>"+
	                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\"></script>"+
	                "<img src='" + imageUrl + "' alt='Hình ảnh'>"+
	                "</body>"+

	            "</html>";
	            
	            mailer.send(acc.getEmail(), subject, content);
	        }
	    } catch (Exception e) {
	        System.out.print("error");
	    }
	    
	    return "redirect:/home/film";
	}
}
