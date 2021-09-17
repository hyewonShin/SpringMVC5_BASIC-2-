package kr.co.hyewon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.hyewon.beans.DataBean1;

@Controller
@SessionAttributes({"sessionBean1" , "sessionBean2"})
//@ModelAttribute로 저장되는 bean객체는 request가 아닌 Session영역에 저장하겠다는 것.
public class TestController {

	//@ModelAttribute를 활용하여 객체를 생성해 반환하는 메서드를 반드시 작성해 줘야 한다.
	@ModelAttribute("sessionBean1")
	public DataBean1 sessionBean1() {
		return new DataBean1();
	}
	
	@ModelAttribute("sessionBean2")
	public DataBean1 sessionBean2() {
		return new DataBean1();
	}
	
	@GetMapping("/test1")
	public String test1(HttpSession session) {
		
		//Session영역은 Request객체로 추출하게 된다.
		//but, Spring에서는 HttpSession으로 바로 사용 가능하다.
		//HttpSession session = request.getSession();
		session.setAttribute("data1", "문자열1");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data1", "문자열2");
		return "redirect:/result1";
	}

	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data1", "문자열3");
		return "forward:/result1";
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		
		DataBean1 bean1 = new DataBean1();
	
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		
		session.setAttribute("bean1", bean1);
		
		return "test4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpSession session) {
	
		DataBean1 bean1 = (DataBean1)session.getAttribute("bean1");
		
		System.out.println("bean1.data1 : " + bean1.getData1());
		System.out.println("bean1.data2 : " + bean1.getData2());
		
		return "result4";
	}
	
	@GetMapping("/result1")
	//public String result1(HttpServletRequest request) {
	//Spring에서는 HttpSession으로 바로 사용 가능하다.
	public String result1(HttpSession session) {
		//HttpSession session = request.getSession();
		String data1 = (String)session.getAttribute("data1");
		System.out.println("Data1 : " + data1);
		
		return "result1";
	}

	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		
		sessionBean1.setData1("문자열6");
		sessionBean1.setData2("문자열7");

		sessionBean2.setData1("문자열8");
		sessionBean2.setData2("문자열9");
		
		return "test5";
		
	}
	
	@GetMapping("/result5")
	public String result5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						  @ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		
		System.out.println("sessionBean1.data1 : " + sessionBean1.getData1());
		System.out.println("sessionBean1.data2 : " + sessionBean1.getData2());
	
		System.out.println("sessionBean2.data1 : " + sessionBean2.getData1());
		System.out.println("sessionBean2.data2 : " + sessionBean2.getData2());
		
		return "result5";
	}


}

// Session
// 브라우저가 최초로 서버에 요청을 하게 되면 브라우저당 하나씩 메모리 공간을 서버에서 할당하게 된다.
// 이 메모리 영역은 브라우저당 하나씩 지정되며 요청이 새롭게 발생하더라도 같은 메모리 공간을 사용하게된다.
// 이러한 공간을 session이라고 부른다.
// 이 영역은 브라우저를 종료할 때까지 서버에서 사용할 수 있다.

// SessionScope
// 브라우저가 최초의 요청을 발생 시키고 브라우저를 닫을 때까지를 SessionScope라고 부른다.
// SessionScope에서는 Session영역에 저장되어 있는 데이터나 객체를 자유롭게 사용할 수 있다.

// Redirect와 Forward 영역에서 session영역에 저장된 데이터를 모두 사용할 수 있다.
// session영역은 새로운 요청이 발생하느냐와 상관없이 브라우저만 바뀌지 않으면 계속 사용될 수 있다.

// @SessionAttribute
// Session 영역에 저장되어 있는 객체를 사용하고자 할 때 메서드의 매개변수로 @SessionAttribute를
// 설정하면 Session영역에 저장되어 있는 Bean을 주입 받을 수 있다.

// @SessionAttributes
// @ModelAttribute를 통해 주입 받는 Bean은 자동으로 Request 영역에 저장되고 Request 영역으로부터
// 주입을 받게 된다.
// 이 때, @ModelAttribute를 통해 주입받는 Bean을 @SessionAttribute로 지정해 놓으면 request
// 영역이 아닌 session 영역에 저장되고 session 영역으로부터 주입 받을 수 있다.
// 주의할 점은 @ModelAttribute를 활용하여 객체를 생성해 반환하는 메서드를 반드시 작성해 줘야 한다.