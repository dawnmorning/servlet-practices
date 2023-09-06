package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	// head랑 body가 request에 들어감
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 개행이 시작되고 보내는 것
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		// query 빼내기
		String name = request.getParameter("name");
		
		pw.println("<h1>Hello world!</h1>");
		pw.println(name);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
