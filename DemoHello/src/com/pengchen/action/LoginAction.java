package com.pengchen.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pengchen.po.User;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	

	public String login() {
		
		System.out.println(user.getUsername());
		System.out.println(user.getBookList().get(0).getUsername());
		System.out.println(user.getBookList().get(1).getUsername());
		//.....
		return SUCCESS;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public void validate() {
		if (user.getUsername() == null 
				|| "".equals(user.getUsername())) {
			this.addFieldError("username", "不能为空");
		}
		
	}
	
	
	
}
