package com.demo;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login.do" })
public class loginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// �����򷵻��û��Ự����
		
		HttpSession session = request.getSession(false);
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		ManageDao dao=new ManageDao();
		Administrator admin=new Administrator(name,pass);
		PrintWriter out = response.getWriter();
		
		
		
		if(dao.loginDo(name, pass)){
			session.setAttribute("admin", admin);
		out.println("<html><body>");
		out.println("��ӭ����" + name + "��¼�ɹ���");
		response.sendRedirect("index.jsp");
		out.println("</body></html>");
	}else {
		out.println("<html><body>"+"�����˺Ż�����������������룡");
		out.println("<a href=\"login.jsp\">���ҷ���</a>");
		out.println("</body></html>");
		
	}
}
}
