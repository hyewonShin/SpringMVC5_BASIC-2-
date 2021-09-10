package kr.co.hyewon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {

		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);

		for( String str1 : data3 ) {
			System.out.println("data3 : " + str1);
		}

		return "result";
	}


	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {

		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data 2");
		String []data3 = request.getParameterValues("data3");

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);

		//checkbox에서 null값이 넘어갈 경우 에러나기 때문에 
	    //null이 아닌 경우에만 출력하도록 if문으로 처리해준다. 
		if(data3 != null) {
			for(String str1 : data3) {
				System.out.println("data3 : " + str1);
			}
		}
		return "result";
	}
	
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		System.out.println(data1);
		System.out.println(data2);
		
		for(String str1 : data3) {
			System.out.println(str1);
		}
		return "result";
	}
	
//	@GetMapping("test4/{data1}/{data2}/{data3}")
//	public String test4(@PathVariable String data1,
//						@PathVariable String data2,
//						@PathVariable String data3) {
//		
//		System.out.println("data1 : " + data1);
//		System.out.println("data2 : " + data2);
//		System.out.println("data3 : " + data3);
//		
//		return "result";
//	}
	
	
	// int로 형변환 후 테스트 출력 	
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable int data1,
						@PathVariable int data2,
						@PathVariable int data3) {
		
		int add = data1 + data2 + data3;
		System.out.println("add : " + add);
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		
		return "result";
	}
	
	@GetMapping("/test5")
	public String test5(@RequestParam int data1,
						@RequestParam int data2,
						@RequestParam int []data3) {
		
		System.out.println("data1 : " + data1);
		System.out.println("data1 : " + data2);
		
		for(int a1 : data3) {
			System.out.println("data3 : " +a1);
		}
	
		return "result";
	}
	
	// value : 파라미터의 이름과 변수의 이름이 다를 경우 파라미터 이름을 지정한다.
	@GetMapping("test6")
	public String test6(@RequestParam(value = "data1") int value1,
						@RequestParam(value = "data2") int value2,
						@RequestParam(value = "data3") int []value3) {
		
		System.out.println("data1 : " + value1);
		System.out.println("data2 : " + value2);
		
		for(int a1 : value3) {
			System.out.println("data3 : " +a1);
		}
		return "result";
	}
	
	//존재하지 않는 파라미터가 없는데 받는다고 한 경우 에러가 발생하다.
	//이때 required = false 설정해주면 에러해결(null값이므로 String으로 받아야함).
	@GetMapping("/test7")
	public String test7(@RequestParam int data1,
						@RequestParam (required = false) String data2,
						@RequestParam(defaultValue = "0") int data3) {
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		
		return "result";
	}
}
