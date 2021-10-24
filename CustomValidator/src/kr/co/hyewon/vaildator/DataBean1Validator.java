package kr.co.hyewon.vaildator;

import javax.validation.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import kr.co.hyewon.beans.DataBean1;

public class DataBean1Validator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DataBean1.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		// 길이가 0이면 error2라는 에러 발생.
		ValidationUtils.rejectIfEmpty(errors, "data2", "error2");
		
		// 길이가 0이거나 공백으로만 채워져 있으면 error3 이라는 에러 발생.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");
	
		
		// rejectValue 사용 
		DataBean1 bean1 = (DataBean1)target;
		
		String data2 = bean1.getData2();
		String data3 = bean1.getData3();
		
		if(data2.length() > 10) {
			errors.rejectValue("data2", "error4");
		}
		
		if(data3.contains("@") == false) {
			errors.rejectValue("data3", "error5");
		}
	}

}
