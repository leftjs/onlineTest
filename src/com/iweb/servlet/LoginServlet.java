package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.iweb.dao.impl.UserDAO;
import com.iweb.entity.User;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		UserDAO userDAO = new UserDAO();
		User user = userDAO.login(loginname, password);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("	</head>");
		out.println("	<body>");
		if(user != null){			
			((HttpServletRequest)request).getSession().setAttribute("user", user);
			if("1".equals(user.getUlevel())){
				out.println("<div align=\"center\">欢迎 " + user.getUname() + ", 登录成功！<a href=\"/user/list.action\">点击进入管理员页面</a></div>");
			}else{
				out.println("<div align=\"center\">欢迎 " + user.getUname() + ", 登录成功！<a href=\"/test.action\">点击开始考试</a></div>");
			}
		}else{
			out.println("<div align=\"center\">登录失败，请重新登录<a href=\"/login.html\">登录</a></div>");
		}         
		out.println("	</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

}
