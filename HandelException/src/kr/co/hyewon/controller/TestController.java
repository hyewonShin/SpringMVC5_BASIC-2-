package kr.co.hyewon.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(Model model) {
		
		//int[] array1 = {10,20,30};
		
		// 정상 로직
		// model.addAttribute("array1",array1[0]);
		
		// 일부러 오류 내기
		//model.addAttribute("array1", array1[10]);
		
		ArrayList<String> list = null;
		list.add("문자열");
		
		
		return "test1";
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String exception1() {
		return "error1";
	}
}


// @ExceptionHandler
// 1) Controller에서 @ExceptionHandler를 통해 메서드를 정의해 주면 오류 발생 시 
//    이 메서드를 자동으로 호출 해줍니다.
// 2) 이 메서드가 반환하는 JSP 정보를 통해 응답결과 화면을 만들고 이 응답결과를 브라우저로 
//    전달하게 됩니다.
// 3) 이 때 사용하는 JSP를 오류 페이지용으로 만들어주면 됩니다.


// Global Exception Handler
// 1) ExceptionHandler는 Controller 마다 만들어 줘야 합니다.
// 2) 만약 Controller 마다 발생 가능한 예외들이 있다면 한번만 정의해서 사용하는것이 효율적이다.
// 3) Global Exception Handler를 구현하면 Controller에 정의한 Exception Handler 중에
// 해당 오류에 대한 것이 었다면 Global Exception Handler로 이동하여 예외에 관련된 처리를 해주게 된다.


