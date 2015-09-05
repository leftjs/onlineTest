package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.iweb.dao.impl.QuestionDAO;
import com.iweb.entity.Question;
import com.iweb.entity.User;


public class TestServlet implements Servlet{

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		QuestionDAO questionDAO = new QuestionDAO();
		List<Question> questions = null;
		try {
			questions = questionDAO.single();
		} catch (Exception e) {
			e.printStackTrace();
		}
		((HttpServletRequest)request).getSession().setAttribute("questions", questions);
		List<Question> q = (List<Question>)((HttpServletRequest)request).getSession().getAttribute("questions");
		System.out.println("test:" + q.size());
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("	<h1 align='center'>欢迎进入考试系统！</h1>");
		out.println("<form action=\"score.action\" method=\"post\">");
		out.println("	<ol id='question'>");
		int flag = 0;
		for(Question single : questions){
			out.println("<li>");
			out.println(single.getQuestion() + "<br/>");
			out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"A\">" + single.getCheck()[0] + "<br/>");
			out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"B\">" + single.getCheck()[1] + "<br/>");
			out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"C\">" + single.getCheck()[2] + "<br/>");
			out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"D\">" + single.getCheck()[3] + "<br/>");	
			out.println("</li>");
			flag++;
			if(flag == 10){
				break;
			}
		}
		
		out.println("	</ol>");
		out.println("	<a href=\"/testweb/score.action\"><input type=\"submit\" value=提交></a>");
		out.println("</form>");
		out.println("	</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
		// TODO Auto-generated method stub
		
	}

