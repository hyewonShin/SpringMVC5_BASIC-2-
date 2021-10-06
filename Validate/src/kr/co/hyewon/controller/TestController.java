package kr.co.hyewon.controller;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hyewon.beans.DataBean1;

@Controller
public class TestController {


	@GetMapping("/input_data")
	public String input_data() {

		return "input_data";
	}

	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {

		System.out.println("data1 : " + dataBean1.getData1());
		System.out.println("data2 : " + dataBean1.getData2());

		System.out.println("BindingResult : " + result);

		// 유효성 검사에서 위반된 부분이 있다면...
		if(result.hasErrors()) {
			// 유효성 위반 결과를 모두 가져온다.
			for(ObjectError obj : result.getAllErrors()) {
				System.out.println("메시지 : " + obj.getDefaultMessage());
				System.out.println("code : " + obj.getCode());
				System.out.println("object name : " + obj.getObjectName());

				String [] codes = obj.getCodes();
				for(String c1 : codes) {
					System.out.println(c1);
				}

				if(codes[0].equals("Size.dataBean1.data1")) {
					System.out.println("data1은 2~10 글자를 담을 수 있습니다");
				} else if(codes[0].equals("Max.dataBean1.data2")) {
					System.out.println("data2는 100이하의 값만 담을 수 있습니다");
				}
				
				System.out.println("---------------------------------------");
			}
			
			return "input_data"; //에러발생시 다시 입력창으로 돌아옴
		}
		
		return "input_success";
	} 

}

// JSR-303 라이브러리를 활용하면 사용자 입력 데이터에 대한 유효성 검사를 할 수 있다.

// @Valid
// Controller의 메서드에서 주입 받는 Bean에 @Valid를 설정하면 유효성 검사를 실시한다.
// 유효성 검사 결과를 사용하고자 한다면 BindingResult 객체를 주입받아야 한다. 
// 이 객체에는 유효성 검사를 실행한 결과 정보가 담겨져있다.
// 이를 통해 Controller에서 사용자가 입력한 값에 문제가 있는지 파악할 수 있다. 


// JSP에서 사용하기
// 만약 JSP에서 잘못 입력한 항목에 대해 메세지를 보여주고 싶다면 errors를 사용하면 된다.
// Controller에서 주입 받았던 BinderResult 객체는 errors라는 이름으로 request영역에 저장된다.
// 이를 이용해 메시지를 출력할 수 있다.