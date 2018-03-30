package com.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsTest extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("Ö´ÐÐaction");
		return SUCCESS;
	}
	
	

}
