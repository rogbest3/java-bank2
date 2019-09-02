package com.bank.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.CustomerBean;
import com.bank.web.services.MemberService;
import com.bank.web.servicesimpl.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  //  public MemberController() {
  //      super();	// super() : HttpServlet, 부모의 생성자  
  //  }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 역직렬화
		System.out.println("맥락이 맞아서 여기 도착");    
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String credit = request.getParameter("credit");
		CustomerBean param = new CustomerBean();
		param.setCredit(credit);
		param.setId(id);
		param.setName(name);
		param.setPw(pw);
		param.setSsn(ssn);
		System.out.println("회원정보 : "+ param.toString());
		
		MemberService service = new MemberServiceImpl();
		service.join(param);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
