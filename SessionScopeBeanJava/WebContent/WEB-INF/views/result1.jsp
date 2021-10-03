<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp 페이지로 bean데이터를 가져오려면 TestController에서 Model에 저장해야된다. -->
	<!-- Model에 저장해준 데이터는  request 영역에 저장된다 -->
	<h1>result1</h1>
	<h3>sessionBean1.data1 : ${requestScope.sessionBean1.data1 }</h3>
	<h3>sessionBean1.data2 : ${requestScope.sessionBean1.data2 }</h3>

	<h3>sessionBean2.data3 : ${requestScope.sessionBean2.data3 }</h3>
	<h3>sessionBean2.data4 : ${requestScope.sessionBean2.data4 }</h3>

	<h3>sessionBean3.data5 : ${requestScope.sessionBean3.data5 }</h3>
	<h3>sessionBean3.data6 : ${requestScope.sessionBean3.data6 }</h3>

	<h3>sessionBean4.data7 : ${requestScope.sessionBean4.data7 }</h3>
	<h3>sessionBean4.data8 : ${requestScope.sessionBean4.data8 }</h3>
</body>
</html>