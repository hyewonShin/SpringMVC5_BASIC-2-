<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<form:form modelAttribute="dataBean" action="result">
		<form:hidden path="a1"/>
		text : <form:input path="a2"/><br/>
		password : <form:password path="a3" showPassword="true"/><br/>
		textarea : <form:textarea path="a4"/><br/>		
		<form:button disabled="true">확인 버튼</form:button>
	</form:form>
</body>
</html>





<%-- 

<form:button> 태그
- Submit 버튼을 생성합니다.
- disabled : true를 셋팅해주면 버튼을 누를 수 없도록 비활성화 된다.

<form:hidden> 태그
- Hidden 타입의 input 태그를 생성합니다.
- path : 설정한 문자열은  id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다. 

<form:input> 태그
- text 타입의 input 태그를 생성합니다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.

<form:password> 태그
- password 타입의 input 태그를 생성합니다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.
- showPassword : 셋팅될 값의 이름을 지정하더라도 값이 세팅되지 않는데 이 속성에 true를 넣어주면 갑이 셋팅된다.

<form:textarea> 태그
- textarea 타입의 input 태그를 생성한다.
- path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.
--%>