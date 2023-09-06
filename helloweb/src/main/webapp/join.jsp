<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String birthYear = request.getParameter("birthYear");
	String gender = request.getParameter("gender");
	String introduce = request.getParameter("introduce");
	
	String[] hobbies = request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=email %> <br>
	<%=password %> <br>
	<%=birthYear %>
	<%=gender %>
	<p>
		<%=introduce.replaceAll("\n", "<br>") %>
	<p>
	<p>
		<%
			for(String hobby : hobbies){
		%>
				<strong><%=hobby %></strong><br>
		<%			
			}
		%>
		<strong>coding</strong>
		<strong>swimming</strong>
	<p>
</body>
</html>