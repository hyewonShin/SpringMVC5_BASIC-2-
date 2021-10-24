package kr.co.hyewon.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hyewon.beans.DataBean1;
import kr.co.hyewon.vaildator.DataBean1Validator;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data(DataBean1 dataBean1) {

		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		if(result.hasErrors()) {
			return "input_data";
		}
		
		return "input_success";
	}
	
	// Validator 커스터마이징 페이지와 연결 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DataBean1Validator validator1 = new DataBean1Validator();
		//binder.setValidator(validator1);
		binder.addValidators(validator1);
	}
}


// ValidateUtils
// 1) rejectifEmpty(error객체,"프로퍼티 이름","코드 이름") 
//	  : 값이 비어 있는지 확인한다. 공백은 글자로 취급한다.
// 2) rejectEmptyOrWhitesapce(error객체,"프로퍼티 이름","코드 이름") 
//	  : 값이 비어있거나 공백으로만 구성되어 있는지 확인한다.
// 3 입력값에 문제가 있다면 error객체에 오류정보를 저장한다. 사용할 오류 메세지는 
//   "코드이름.bean객체이름.프로퍼티이름"으로 구성된다.

// rejectValue
// 1) 유효성 조건을 직접 만들어 검사할 때 사용한다.
// 2) if문으로 유효성 검사를 해주고 위배시 rejectValue를 통해 오류 정보를 지정한다.
// 3) rejectValue("프로퍼티 이름", "코드이름")
// 3) 입력값에 문제가 있다면 error 객체에 오류정보를 저장한다. 사용할 오류 메세지는 
//     "코드이름.bean객체이름.프로퍼티이름"으로 구성된다.

