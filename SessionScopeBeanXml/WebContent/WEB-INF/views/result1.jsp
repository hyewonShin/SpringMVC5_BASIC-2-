<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result1</h1>
	<h3>sessionBean1.data1 : ${requestScope.sessionBean1.data1 }</h3>
	<h3>sessionBean1.data2 : ${requestScope.sessionBean1.data2 }</h3>

	<!-- xml에서 이름으로 주입받은 빈은 session영역에 저장된다. -->
	<!-- jsp 에서 사용하기위해 따로 Model에 저장하지 않아도 된다. -->
	<h3>sessionBean2.data3 : ${sessionScope.sessionBean2.data3 }</h3>
	<h3>sessionBean2.data4 : ${sessionScope.sessionBean2.data4 }</h3>

	<h3>sessionBean3.data5 : ${requestScope.sessionBean3.data5 }</h3>
	<h3>sessionBean3.data6 : ${requestScope.sessionBean3.data6 }</h3>
	
	<!-- component로 등록한 빈은 이름을 지정해줘도 session영역에 자동으로 저장되지 않는다. -->
	<h3>sessionBean4.data7 : ${requestScope.sessionBean4.data7 }</h3>
	<h3>sessionBean4.data8 : ${requestScope.sessionBean4.data8 }</h3>
</body>
</html>