package kr.co.hyewon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hyewon.beans.DataBean;

@Controller
public class TestController {

	@PostMapping("/test1")
	public String test1(DataBean bean) {
		
		System.out.println(bean.getData1());
		System.out.println(bean.getData2());
		
		return "test1";
	}

	@PostMapping("/test2")
	//클래스 이름 대신에 "testData"라는 새로운 이름 생성
	public String test2(@ModelAttribute("testData") DataBean bean) {
		
		System.out.println(bean.getData1());
		System.out.println(bean.getData2());
		
		return "test2";
	}
}

//커맨드 객체
//:클라이언트가 전달해 주는 파라미터 데이터를 주입 받기 위해 사용하는 객체 
//ex) @ModelAttribute
//커맨드 객체는 HttpServletRequest 객체에 자동으로 담기고 jsp로 전달된다.
//이때, HttpServletRequest 객체에 저장되는 이름은 클래스의 이름으로 결정된다.
//(앞글자는 소문자로 변환해준다.)
