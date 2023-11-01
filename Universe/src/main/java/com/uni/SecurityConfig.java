package com.uni;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.uni.entity.Taikhoan;
import com.uni.service.TaikhoanService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired 
	TaikhoanService taikhoanService;
	@Autowired 
	BCryptPasswordEncoder pe;
	
	//Cung cấp nguồn dữ liệu đăng nhập
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username->{
			try {
				Taikhoan user = taikhoanService.findById(username);
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAuthorities().stream()
						.map(el->el.getVaitro().getMavaitro())
						.collect(Collectors.toList()).toArray(new String[0]);
				System.out.println(1);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (Exception e) {
				System.out.println(0);
				throw new UsernameNotFoundException(username + "not found!");
			}
		});
	}
	
	//Phân quyền sử dụng
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
//			.antMatchers("/home/booking/ticket/**").authenticated()
//			.antMatchers("/admin/**").hasAnyRole("STAFF","ADMIN")
			.antMatchers("/rest/staff").hasRole("ADMIN")
			.anyRequest().permitAll();
		
		http.formLogin()
			.loginPage("/home/login/form")
			.loginProcessingUrl("/home/login")
			.defaultSuccessUrl("/home/index",false)
			.failureUrl("/home/login/error");
		
		
		http.logout()
			.logoutUrl("/home/logoff")
			.logoutSuccessUrl("/home/logoff/success");
	}
	
	//Cơ chế mã hoá mật khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Cho phép truy xuất REST API từ bên ngoài (domain khác)
	
	@Override 
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**"); 
	}
	 
}
