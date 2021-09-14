package kr.co.hyewon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1() {
		
		return "redirect:/sub1";
	}

	@GetMapping("/sub1")
	public String sub1() {
		
		return "sub1";
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "forward:/sub2";
	}

	@GetMapping("/sub2")
	public String sub2() {
		return "sub2";
	}
}

// Redirect
//-Redirect는 서버가 클라이언트에게 요청할 주소를 응답결과로 전달하는 것을 의미합니다.
//-클라이언트는 응답결과로 받은 요청주소를 직접 요청하게 됩니다.
//-브라우저가 요청하는 것이므로 주소창의 주소는 변경됩니다.
//-Redirect는 새로운 요청이 발생하는 것이므로 HttpServletRequest 객체를 소멸후 새롭게 생성되며
// HttpSession 객체는 그대로 유지됩니다.

// Forword
// 코드의 흐름을 서버상에서만 이동하는 것을 의미합니다.
// 브라우저는 다른 곳으로 흐름이 이동되었다는 것을 알 수 없기 때문에 주소창의 주소는 변경되지 않습니다.
// HttpServletRequest, HttpSession 모두 유지됩니다.
