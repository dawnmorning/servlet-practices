package com.poscodx.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.eamaillist.dao.EmailListDao;
import com.poscodx.eamaillist.vo.EmailListVo;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().print("<h1>Dawn</h1>");
		// /el?a=?의 값에 따른 forward
		String action = request.getParameter("a");
		if("add".equals(action)) {
			
		} else if("form".equals(action)) {
			
		} else {
			List<EmailListVo> list = new EmailListDao().findAll();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
