package kr.co.hyewon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.hyewon.beans.DataBean1;
import kr.co.hyewon.beans.DataBean2;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {

	@Bean
	@RequestScope //새로운 요청이 발생했을 때 빈 주입.
	public DataBean1 dataBean1() {
		return new DataBean1();  // 빈 객체 생성
	}
	
	@Bean("requestBean2") //bean의 이름을 지정해줌
	@RequestScope
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
	
}
