package com.pengchen.action;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class HelloWorldAction extends ActionSupport {
	private HttpServletRequest request;
	
	
	public String add() {
		request.setAttribute("path", "update");
		return "add";
	}
	
	public String update() {
		return "update";
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("execute action success!");
		
		return SUCCESS;
	}

		
}