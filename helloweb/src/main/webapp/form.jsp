<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Form 입니다.</h1>
	<form action="/helloweb/join.jsp" method="post">
		<label>이메일</label>
		<input type="text" name="email" value="">
		<br><br>
		
		<label>비밀번호</label>
		<input type="password" name="password" value="">
		<br><br>
		
		<label>생년월일</label>
		<select name="birthYear">
			<option value="2000">2000년</option>
			<option value="1999">1999년</option>
			<option value="1998">1998년</option>
			<option value="1997">1997년</option>
		</select>
		<br><br>
		
		<label>성별
		남<input type="radio" name="gender" value="male" checked="checked">
		여<input type="radio" name="gender" value="female">
		</label>
		<br><br>

		<label>자기소개</label>
		<textarea name="introduce"></textarea>
		<br><br>
		
		<label>취미</label> <br>
		코딩: <input type="checkbox" name="hobby" value="coding">
		음주가무: <input type="checkbox" name="hobby" value="drinking">
		요리: <input type="checkbox" name="hobby" value="cook">
		수영: <input type="checkbox" name="hobby" value="swimming">
		<br><br>
		
		<input type="submit" value="가입">		

	</form>
</body>
</html>