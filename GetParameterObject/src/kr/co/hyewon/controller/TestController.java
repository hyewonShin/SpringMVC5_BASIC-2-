package kr.co.hyewon.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.hyewon.beans.DataBean;
import kr.co.hyewon.beans.DataBean2;


@Controller
public class TestController {

	//Map을 이용하여 파라미터의 값을 한번에 받을 수 있다. 
	//단 동일명으로 전달되는 2개 이상의 파라미터는 하나만 담기데 된다.
	//동일 명으로 전달되는 파라미터가 2개 이상이라면 List로 주입 받아야 한다.
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, @RequestParam List<String> data3) {
	//정수 객채만 넘어와도 String으로 받기 때문에 <String, String>으로 해주어야한다.
	//Map이나 List는 무조건 문자열로 받아야 한다. 
		
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data33 = map.get("data3");
		
		System.out.println("Data1 : " + data1);
		System.out.println("Data2 : " + data2);
		System.out.println("Data33 : " + data33);
		
		for(String str1 : data3) {
			System.out.println("data3 : " + str1);
		}
		
		return "result";
	}
	
	@GetMapping("/test2")
	//public String test2(@ModelAttribute DataBean bean1, @ModelAttribute DataBean2 bean2) {
	//@ModelAttribute 어노테이션은 생략해도 된다.
	public String test2(DataBean bean1, DataBean2 bean2) {	
		System.out.println("data1 : " + bean1.getData1());
		System.out.println("data2 : " + bean1.getData2());
		
		for(int number1 : bean1.getData3()) {
			System.out.println("data3 : " + number1);
		}
		
		System.out.println(bean2.getData1());
		System.out.println(bean2.getData2());
		
		return "result";
	}
}
