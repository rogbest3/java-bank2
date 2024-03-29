package com.bank.web.domains;

import java.io.Serializable;

public class AccountBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String accountNum, today;
	private int money;
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accountNum 
				+ ", 가입일=" + today 
				+ ", 금액=" + money 
				+ "]";
	}
	
	
}
