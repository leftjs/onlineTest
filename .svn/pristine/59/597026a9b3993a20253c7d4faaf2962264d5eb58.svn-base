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

public class RemoveUserServlet implements Servlet {

	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		    
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDAO userDAO = new UserDAO();
		try{
			if(userDAO.remove(id)){
				request.setAttribute("msg", "删除成功！");		
			}else{
				request.setAttribute("msg", "删除失败！");
			}
			((HttpServletRequest)request).getSession().setAttribute("msg", "恭喜删除成功");
			request.getRequestDispatcher("list.action").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
