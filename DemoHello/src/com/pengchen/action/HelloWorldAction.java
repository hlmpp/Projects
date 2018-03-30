package com.pengchen.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		System.out.println("execute action success!");
		
		return SUCCESS;
	}

		
}