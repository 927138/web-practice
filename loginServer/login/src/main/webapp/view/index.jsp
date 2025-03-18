<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Home page</h2>


<div>
	<button onclick="location.href='/loginAPI/member'">membership</button>
	<button onclick="location.href='/loginAPI/login'">login</button>
</div>

<p>user input : ${ input }</p>
<h2>${ input }</h2>

</body>
</html>