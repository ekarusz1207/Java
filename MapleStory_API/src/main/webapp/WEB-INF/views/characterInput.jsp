<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Character Info</title>
</head>
<body>
	<h1>캐릭터 닉네임으로 검색</h1>
	<form action="/getCharacterInfo" method="get">
		<label for="nickname">캐릭터 닉네임 입력 :</label>
		<input type="text" id="nickname" name="nickname" required>
		<button type="submit">검색하기</button>
	</form>
	<% String error = (String) request.getAttribute("error"); %>
	<% if (error != null) { %>
	    <p style="color: red;"><%= error %></p>
	<% } %>	
</body>
</html>