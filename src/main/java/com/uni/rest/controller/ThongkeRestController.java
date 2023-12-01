package com.uni.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.service.AuthorityService;
import com.uni.service.PhimService;
import com.uni.service.TaikhoanService;
import com.uni.service.VeService;

@RestController
@RequestMapping("rest/thongke")
public class ThongkeRestController {
	@Autowired private VeService veService;
	@Autowired private PhimService phimService;
	@Autowired private TaikhoanService taikhoanService;
	@Autowired private AuthorityService auService;
	
	@GetMapping("firstRow")
	public Map<String,Object> showSummary(){
		Map<String,Object> map = new HashMap<>();
		map.put("todayVe", veService.getToDayVe());
		map.put("totalVe", veService.totalVe());
		map.put("totalPhim", phimService.getTotalPhim());
		map.put("totalProduct", phimService.getTotalPhim());
		map.put("todayIncome", veService.getTodayIncome());
		map.put("totalIncome", veService.getTotalIncome());
		map.put("totalCustomer", auService.getTotalCustomer());
		map.put("totalAccount", taikhoanService.getTotalTK());
		return map;
	}
	
	
	@GetMapping("secondRow")
	public Map<String,List<Object[]>> showSecond(){
		Map<String,List<Object[]>> map = new HashMap<>();
		map.put("revenueLast7Days", veService.getRevenueLast7Days());		
		return map;
	}
	@GetMapping("fourthRow")
	public Map<String,List<Object[]>> fourthRow(){
		Map<String,List<Object[]>> map = new HashMap<>();
		map.put("top10SoldPhim", phimService.top10phim());
		return map;
	}
	

	@GetMapping("fifthRow")
	public Map<String,List<Object[]>> fifthRow(){
		Map<String,List<Object[]>> map = new HashMap<>();
		map.put("topCustomer", taikhoanService.top10Customer());
		return map;
	}
}
