<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Write Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-bottom: 20px;
        }
        button:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            text-align: center;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
        }
        thead tr {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <button onclick="location.href='/loginAPI/write'">Write</button>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>${post.idx}</td>
                    <td>${post.name}</td>
                    <td>${post.title}</td>
                    <td>${post.content}</td>
                    <td>${post.postdate}</td>
                    <td>${post.visitcount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>

</html>