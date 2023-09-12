<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String color = request.getParameter("c");
    String colorStyle = "";
    
    if ("red".equals(color)) {
        colorStyle = "color:red";
    } else if ("green".equals(color)) {
        colorStyle = "color:green";
    } else if ("blue".equals(color)) {
        colorStyle = "color:blue";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h1 style="<%=colorStyle%>">Hello World</h1>
</body>
</html>
