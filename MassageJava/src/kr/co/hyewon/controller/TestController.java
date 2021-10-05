package kr.co.hyewon.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	//MassageSource를 주입받는다.
	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/test1")
	public String test1(Model model, Locale locale) {
	
		System.out.println("locale : " + locale);
		
		//첫번째 매개변수
		//properties파일의 불러낼 key값 작성 
		String a1 = res.getMessage("aaa.a1", null, null);
		String b1 = res.getMessage("bbb.b1", null, null);
		
		// 두번째 매개변수 
		// properties파일의 {} 부분에 셋팅할 값 배열
		Object [] args = {27,"신혜원"};
		String a2 = res.getMessage("aaa.a2", args, null);
		
		// 세번째 매개변수 
		// 다국어 처리(Locale 지정)
		String a3 = res.getMessage("aaa.a3", null, locale);
		
		
		System.out.println("aaa.a1 :" + a1);
		System.out.println("bbb.b1 :" + b1);
		System.out.println("aaa.a2 :" + a2);
		System.out.println("aaa.a3 :" + a3);

		// {}부분에 넣어줄 값을 jsp에서 사용하기위해 Model에 넣어준다.
		model.addAttribute("args",args);
		
		return "test1";
	}
}
