package com.pengchen.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pengchen.po.User;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}



	private User user;
	
	
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String login() {
		System.out.println(user.getUsername());
		//.....
		return SUCCESS;
	}
}
