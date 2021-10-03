package kr.co.hyewon.controller;

import javax.servlet.ServletContext;

import org.apache.taglibs.standard.lang.jstl.test.Bean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.hyewon.beans.DataBean1;

@Controller
public class TestController {

	@Autowired
	ServletContext application;
	
	@GetMapping("/test1")
	//public String test1(HttpServletRequest request) {
	public String test1() {
	
		//ServletContext application = request.getServletContext();
		application.setAttribute("data1", "문자열1");
		
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("data1");
		bean1.setData2("data2");
		
		application.setAttribute("bean1", bean1);
		
		return "test1";
	}

	@GetMapping("/result1")
	//public String result1(HttpServletRequest request) {
	public String result1() {

		//ServletContext application = request.getServletContext();
		String data1 = (String)application.getAttribute("data1");
		
		System.out.println("data1 : " + data1);
		
		DataBean1 bean1 = (DataBean1)application.getAttribute("bean1");
		System.out.println("bean1.data1 : " + bean1.getData1());
		System.out.println("bean1.data2 : " + bean1.getData2());
		
		return "result1";
	}
	

	//application영역에 저장하면 모든 브라우저에서 사용 가능하다.
}
