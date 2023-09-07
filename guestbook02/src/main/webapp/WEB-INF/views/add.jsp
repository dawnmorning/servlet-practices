<%@page import="java.sql.Timestamp"%>
<%@page import="com.poscodx.guestbook.dao.GuestBookDao"%>
<%@page import="com.poscodx.guestbook.vo.GuestBookVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");
	Date currentDate = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	String reg_Date = formatter.format(currentDate);
	
	GuestBookVo vo = new GuestBookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(message);
	vo.setDate(reg_Date);
	new GuestBookDao().guestBookInsert(vo);
	response.sendRedirect("/guestbook02/gb");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>