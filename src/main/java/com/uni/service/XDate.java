package com.uni.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class XDate {
	public String convertToPattern(Date yourdate, String pattern) {
		return new SimpleDateFormat(pattern).format(yourdate);
	}
}
