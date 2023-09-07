package com.poscodx.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.eamaillist.dao.EmailListDao;
import com.poscodx.eamaillist.vo.EmailListVo;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().print("<h1>Dawn</h1>");
		// /el?a=?의 값에 따른 forward
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("a");
		// form의 주소명을 좀 더 깔끔하게. input hiddden을 통해 해당 페이지를 인식
		if ("add".equals(action)) {
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");
			
			EmailListVo vo = new EmailListVo();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			new EmailListDao().insert(vo);
			
			response.sendRedirect("/emaillist02/el");
			
		} else if ("form".equals(action)) {
			// form 으로 유저가 왔고, 내가 뭘 해줄까?를 생각
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(request, response);
		} else {
			List<EmailListVo> list = new EmailListDao().findAll();
			
			// 어떻게 넘겨줄 것인가
			request.setAttribute("list", list);
			// 보내즈아
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
