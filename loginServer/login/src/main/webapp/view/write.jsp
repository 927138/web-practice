<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>데이터 입력</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            width: 300px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">데이터 입력 폼</h2>
    <form action="/loginAPI/write" method="post">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required>

        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required>

        <label for="content">내용:</label>
        <textarea id="content" name="content" rows="5" required></textarea>

        <button type="submit">저장</button>
    </form>
</body>
</html>
