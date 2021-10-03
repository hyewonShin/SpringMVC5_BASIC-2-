package kr.co.hyewon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.hyewon.beans.DataBean1;
import kr.co.hyewon.beans.DataBean2;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	
	@Bean  //클래스를 빈으로 틍록
	@SessionScope
	public DataBean1 dataBean1() {
		return new DataBean1();
	}
	
	@Bean("sessionBean2")  //이름 정의
	@SessionScope
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
 
}
