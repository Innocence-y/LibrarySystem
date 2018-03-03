package com.nuc.library.book.action;

import com.opensymphony.xwork2.ActionSupport;

public class TransformAction extends ActionSupport {
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String execute(){
		return SUCCESS;
	}
	
}
