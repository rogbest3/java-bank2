package com.bank.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;
import com.bank.web.servicesimpl.AccountServiceImpl;
import java.util.List;
import java.util.ArrayList;
/**
 * Servlet implementation class AccountController
 */
@WebServlet("/account.do")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    AccountService accountService = new AccountServiceImp();
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		AccountService accountService = new AccountServiceImpl();
		List <AccountBean> accounts = new ArrayList<>();
		System.out.println("연결 ok");
		String money = request.getParameter("money");	// 자동 역직렬화되어 split할 필요 없음
	//	AccountBean a = new AccountBean();
	//	a.setMoney(Integer.parseInt(money));
	//	System.out.println("입금액 : "+ a.getMoney());
		accountService.createAccount(Integer.parseInt(money));
		accounts = accountService.findAll();
		System.out.println(accountService.countAccounts());
		for(int i=0;i<accountService.countAccounts();i++) {
			System.out.println(accounts.get(i).toString());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
