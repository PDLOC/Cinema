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

import com.uni.dao.TaiKhoanDAO;
import com.uni.service.ChitietphimService;
import com.uni.entity.Chitietphim;
import com.uni.entity.Lich;
import com.uni.entity.Loaighe;
import com.uni.entity.Taikhoan;
import com.uni.entity.Ve;
import com.uni.entity.Combo;
import com.uni.entity.Ghe;
import com.uni.entity.Khuyenmai;
import com.uni.service.KmService;
import com.uni.service.LoaiGheService;
import com.uni.service.PaymentService;
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
	
	@Autowired
	PaymentService paymentService;

	@RequestMapping("booking/ticket/{mapc}/{mact}/{gioBatDau}")
	public String ticket(Model model, @PathVariable("mapc") String mapc, @PathVariable("mact") String mact,
			@PathVariable("gioBatDau") String Giobatdau) {
		Chitietphim CtPhim = CtphimService.findById(mact);
		// Hiển thị Giờ bắt đầu và Giờ kết thúc
		for (Lich L : CtPhim.getListlich()) {
			if (L.getGiobatdau().toString().contains(Giobatdau)) {
				model.addAttribute("itemL", L);
				System.out.println(L.getStt());
			}
		}
		model.addAttribute("itemCt", CtPhim);

		// loaiGhe
		List<Loaighe> Lghe = LgheService.findAll();
		model.addAttribute("itemLGhe", Lghe);

		// comBo
		List<Combo> combo = comboService.findAll();
		model.addAttribute("itemComBo", combo);

		// khuyen mai
		List<Khuyenmai> km = khuyenMaiService.findAll();
		model.addAttribute("itemKM", km);

		// Ghế
		List<Ghe> ghe = gheService.findByMaphong(mapc);
		model.addAttribute("listGhe", ghe);

		return "home/seat/bookseat";
	}

	@RequestMapping("booking/ticket/pay/{totalPay}")
	public String payment(@PathVariable("totalPay") long totalpay) {
		PaymentService pc = new PaymentService();
		String urlpay = null;
		try {
			urlpay = pc.payment(totalpay);
		} catch (Exception e) {
			System.out.print(e);
		}
		return "redirect:" + urlpay;
	}

	@RequestMapping("booking/SendBill/{username}/{nameMovie}/{suatChieu}/{ngayChieu}/{seatPositionElement.textContent}/{totalSeat}/{seatPrice}/{room}/{totalPriceFood}/{discount}/{totalAmount1}/{ticketCode}")
	public String sendMail(@PathVariable("username") String username, 
			@PathVariable("nameMovie") String nameMovie,
			@PathVariable("suatChieu") String timeMovie, 
			@PathVariable("ngayChieu") String dateMovie,
			@PathVariable("seatPositionElement.textContent") String ghe,
			@PathVariable("totalSeat")String totalSeat ,
			@PathVariable("seatPrice")String seatPrice,
			@PathVariable("room") String room,
			@PathVariable("totalPriceFood") String totalPriceFood,
			@PathVariable("discount")String discount,
			@PathVariable("totalAmount1") String thanhtien,
			@PathVariable("ticketCode")Integer mave) {
		
		try {
			if (username != null) {
				Taikhoan acc = accountDao.findById(username).get();
				String imageUrl = "https://res.cloudinary.com/denbzrony/image/upload/v1702100071/ipweqzcmyymygwqdwhxb.png";
				String subject = "Thông Tin Vé";
				String content = "<html>" +
                         "<head>" +
                             "<style>" +
                                 "body {" +
                                     "font-family: Arial, sans-serif;" +
                                 "}" +
                             "</style>" +
                         "</head>" +
                         "<body>" +
                             "<h2 style='color: #333333;'>Thông Tin Vé</h2>" +
                             "<p><strong>Mã vé:</strong> " + mave +"</p>"+
                             "<p><strong>Tên phim:</strong> " + nameMovie +"</p>"+
                             "<p><strong>Rạp:</strong> Universe Cinema "+" - "+ room +"</p>"+
                             "<p><strong>Ngày chiếu:</strong> " + dateMovie + " - "+timeMovie+"</p>" +
                             "<p><strong>Ghế:</strong> " + ghe +"</p>"+
                             "<p><strong>Giá:</strong> " + seatPrice + " x " + totalSeat +"</p>"+
                             "<p><strong>Combo:</strong> " + totalPriceFood +"</p>"+
                             "<p><strong>Khuyến mãi:</strong> " + discount +"%</p>"+
                             "<hr>" +
                             "<p><strong>Thành tiền:</strong> " + thanhtien +"</p>"+
                             "<br>" +
                         "</body>" +
                      "</html>";
				mailer.send(acc.getEmail(), subject, content);
			}
		} catch (Exception e) {
			System.out.print("error");
		}

		return "redirect:/home/film";
	}
}
