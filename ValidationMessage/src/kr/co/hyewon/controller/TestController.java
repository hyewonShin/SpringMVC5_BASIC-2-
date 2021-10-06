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
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		if(result.hasErrors()) {
			return "input_data";
		}
		
		return "input_success";
	}
}


// Form 데이터 유지하기
// 유효성 검증에 통과하지 못해 다시 입력 화면으로 돌아왔을 때 기존에 입력했던 내용을 유지해야 할 경우가 있다.
// 이 떄 입력 화면으로 전달된 Bean 객체에서 input 태그에 값을 주입하면 된다.
// 전에 살펴 보았던 Spring MVC의 Form 커스텀 태그를 활용하면 된다.
// 이 때, 검증 실패 문자열도 손쉽게 셋팅하는 것이 가능하다.

// Properties 파일을 활용하면 에러 메시지를 설정할 수 있다.