<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='test1?data1=100&data2=200&data3=300&data3=400'>test1 get</a><br/>
	
	<hr/>
	<form action="test2" method="post">
		data1 : <input type="text" name='data1'/><br/>
		data2 : <input type="text" name='data2'/><br/>
		data3 : <input type="checkbox" name='data3' value="100"/>data3 100
				<input type="checkbox" name='data3' value="200"/>data3 200<br/>
		<button type="submit">test post</button>
	</form>
	
	<hr/>
	<!-- 이름으로 데이터 추출  -->
	<a href="test3?data1=100&data2=200&data3=300&data3=400">test3</a><br/>
	
	<hr/>
	<!--RestfullAPI / @PathVariable / (요청주소/값1/값2/값3) -->
	<!-- 순서로 데이터 추출 -->
	<a href="test4/100/200/300">test4</a><br/>
	
	<hr/>
	<!-- @RequestParam
	- 지정된 변수의 이름과 파라미터의 이름이 같을 경우 파리미터 데이터를 직접 주입 받음 -->
	<a href='test5?data1=100&data2=200&data3=300&data3=400'>test5</a><br/>
	
	<hr/>
	<a href="test6?data1=100&data2=200&data3=300&data3=400">test6</a><br/>

	<hr/>
	<a href="test7?data1=100">test7</a><br/>
	
</body>
</html>