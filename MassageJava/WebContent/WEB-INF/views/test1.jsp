<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp에서 Message에 있는 데이터를 사용하기 위해서는 아래와같이 태그를 설정해줘야된다. -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<h3>aaa.a1 : <spring:message code='aaa.a1'/></h3>
	<h3>bbb.b1 : <spring:message code='bbb.b1'/></h3>
	
	<!-- properties파일에서 {} 안에 들어갈 값 세팅 / 출력 -->
	<h3>aaa.a2 : <spring:message code='aaa.a2' arguments="${args }"/></h3>

	<!-- 다국어처리(현재 브라우저를 적용해서 자동으로 처리해줌)  -->
	<h3>aaa.a3 : <spring:message code='aaa.a3'/></h3>
</body>
</html>