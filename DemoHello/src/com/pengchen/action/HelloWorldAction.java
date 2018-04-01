package com.pengchen.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	
	
	public String add() {
		return SUCCESS;
	}
	
	public String update() {
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("execute action success!");
		
		return SUCCESS;
	}

		
}