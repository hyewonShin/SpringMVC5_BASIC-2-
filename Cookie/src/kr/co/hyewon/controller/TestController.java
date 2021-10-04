package kr.co.hyewon.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/save_cookie")
	public String save_cookie(HttpServletResponse response) {
		
		try {
			String data1 = URLEncoder.encode("문자열1","UTF-8");
			String data2 = URLEncoder.encode("문자열2","UTF-8");
			
			Cookie cookie1 = new Cookie("cookie1", data1);
			Cookie cookie2 = new Cookie("cookie2", data2);
			
			cookie1.setMaxAge(365 * 24 * 60 *60);
			cookie2.setMaxAge(365 * 24 * 60 *60);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "save_cookie";
	}

	//Servlet/JSP에서 쿠키 정보를 배열로 받아 사용하는 방법(번거롭다)
	@GetMapping("/load_cookie")
	public String load_cookie(HttpServletRequest request) {
		
		try {
			
			Cookie [] cookies = request.getCookies();
			
			for(Cookie cookie : cookies) {
				String str = URLDecoder.decode(cookie.getValue(), "UTF-8");
				
				if(cookie.getName().equals("cookie1")) {
					System.out.println("cookie1 : " + str);
				} else if(cookie.getName().equals("cookie2")) {
					System.out.println("cookie2 : " + str);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "load_cookie";
	}
	
	
	//스프링에서 편리하게 cookie 사용하는 방법(encoding도 자동으로 됌)
	//@CookieValue 어노테이션 사용(이름 지정해주면 동일한 이름의 쿠키 정보가 주입됌)
	@GetMapping("/load_cookie2")
	public String loac_cookie2(@CookieValue("cookie1") String cookie1,
			                   @CookieValue("cookie2") String cookie2) {
		
		System.out.println("cookie1 :" + cookie1);
		System.out.println("cookie1 :" + cookie2);
		
		return "load_cookie2";
	}
}











