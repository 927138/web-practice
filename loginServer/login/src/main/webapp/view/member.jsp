<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/member/todo" method="post">
	id : <input type="text" name="userId"> <br>
	pw : <input type="text" name="userPw"> <br>
	email : <input type="text" name="userEmail"> <br>
	
	<button type="submit">create Member</button>
</form>
</body>
</html>