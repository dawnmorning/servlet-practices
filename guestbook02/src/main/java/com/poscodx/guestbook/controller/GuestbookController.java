package com.poscodx.guestbook.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.guestbook.dao.GuestBookDao;
import com.poscodx.guestbook.vo.GuestBookVo;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("g");
		// form의 주소명을 좀 더 깔끔하게. input hiddden을 통해 해당 페이지를 인식
		if ("add".equals(action)) {
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

		} else if ("deleteform".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		}
		else if ("delete".equals(action)) {
			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");
			
			GuestBookDao dao = new GuestBookDao();
			dao.guestBookDeleteByPassWord(no, password);
			// form 으로 유저가 왔고, 내가 뭘 해줄까?를 생각
			response.sendRedirect("/guestbook02/gb");
		} else {
			List<GuestBookVo> list = new GuestBookDao().guestBookfindAll();

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
