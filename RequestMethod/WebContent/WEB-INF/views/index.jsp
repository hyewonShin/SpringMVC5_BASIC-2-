<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href='test1'>Test1 get</a>
	<br/>

	<hr/>
	<a href='test2'>Test2 post</a>
	<br/>
	<form action="test2" method="post">
		<button type="submit">test2_post</button>
	</form>

	<hr/>
	<a href="test3">test3_get</a>
	<form action="test3" method="post">
		<button type="submit">test3_post</button>
	</form>

	<hr/>
	<a href="test4">test4_GET</a>
	<form action="test4" method="post">
		<button type='submit'>test4_post</button>
	</form>

	<hr/>
	<a href="test5">test5_GET</a>
	<form action="test5" method="post">
		<button type='submit'>test5_post</button>
	</form>

	<hr/>
	<a href="test6">test6_GET</a>
	<form action="test6" method="post">
		<button type='submit'>test6_post</button>
	</form>
	
</body>
</html>