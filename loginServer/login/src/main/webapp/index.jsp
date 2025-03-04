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

<jsp:include page="/common/category.jsp"/>



<div>
	<button onclick="location.href='/member/membership.jsp'">membership</button>
	<button onclick="location.href='/member/login.jsp'">login</button>
</div>

	
	

</body>
</html>