package kr.co.hyewon.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hyewon.beans.DataBean1;

@Controller
public class TestController {

	@GetMapping("/input_data") 
	public String input_data(DataBean1 dataBean1) {
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String intput_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		if(result.hasErrors()) {
			return "input_data";
		}
		return "input_success";
	}
}


// JSR-303
// @AssertTrue : true가 아닌 값이 들어오면 오류
// @AssertFalse : false가 아닌 값이 들어오면 오류
// @Max(값) : 값보다 큰 값이 들어오면 오류 
// @Min(값) : 값보다 작은 값이 들어오면 오류 
