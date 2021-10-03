package kr.co.hyewon.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.hyewon.beans.DataBean1;
import kr.co.hyewon.beans.DataBean2;
import kr.co.hyewon.beans.DataBean3;
import kr.co.hyewon.beans.DataBean4;

@Controller
public class TestController {

	@Autowired  // 타입으로 주입
	DataBean1 sessionBean1;
	
	@Resource(name = "sessionBean2")  //이름으로 주입
	DataBean2 sessionBean2;
	
	@Autowired
	DataBean3 sessionBean3;
	
	@Resource(name = "sessionBean4")
	DataBean4 sessionBean4;
	
	
	@GetMapping("/test1")
	public String test1() {
		
		sessionBean1.setData1("data1");
		sessionBean1.setData2("data2");

		sessionBean2.setData3("data3");
		sessionBean2.setData4("data4");

		sessionBean3.setData5("data5");
		sessionBean3.setData6("data6");
		
		sessionBean4.setData7("data7");
		sessionBean4.setData8("data8");
		
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		
		System.out.println("data1 : " + sessionBean1.getData1());
		System.out.println("data2 : " + sessionBean1.getData2());
		
		System.out.println("data3 : " + sessionBean2.getData3());
		System.out.println("data4 : " + sessionBean2.getData4());

		System.out.println("data5 : " + sessionBean3.getData5());
		System.out.println("data6 : " + sessionBean3.getData6());
		
		System.out.println("data7 : " + sessionBean4.getData7());
		System.out.println("data8 : " + sessionBean4.getData8());
		
		model.addAttribute("sessionBean1", sessionBean1);
		model.addAttribute("sessionBean2", sessionBean2);
		model.addAttribute("sessionBean3", sessionBean3);
		model.addAttribute("sessionBean4", sessionBean4);
		
		return "result1";
	}
}
