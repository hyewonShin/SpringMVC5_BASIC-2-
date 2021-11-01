package kr.co.hyewon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicContorller {

	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
}
