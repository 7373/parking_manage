package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="registerServlet",urlPatterns={"/register.do"})
public class registerServlet extends HttpServlet {
public void doPost(HttpServletRequest request, 
HttpServletResponse response)
                     throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ManageDao dao=new ManageDao();
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		if(dao.addCustomer(username, password)){
   
        out.println("<html><head><span style=\"font-size:18px;\"></span><span style=\"font-size:24px;\"><meta http-equiv=\"refresh\" content=\"3;URL=index.jsp\"> </span><span style=\"font-size:24px;\"><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" /><title>ע��ɹ���</title><br></head><body>");
        out.println("<table width=\"300\" border=\"0\" align=\"center\"><tr><td align=\"center\"> \"��ϲ����"+username+"ע��ɹ���\"<br><a href=\"index.jsp\">3��֮����ת��ҳ��û��ת���ң�</a> </td> </tr></table> ");
        out.println("</body></html>");
		}
		else {
			out.println("<html><body>"+"ע��ʧ�ܣ�");
			out.println("</body></html>");
			
		}
			
}
}
