package kr.co.hyewon.dao;

import org.springframework.stereotype.Repository;

@Repository //@component와 같은 기능인데 식별하기 위해 이름을 다르게 사용한 것. 
public class TestDAO {

	public String testDaoMethod() {
		return "문자열";
	}
}
