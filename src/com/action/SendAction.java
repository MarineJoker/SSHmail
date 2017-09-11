package com.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport{
	public String execute(){
		return "send";
	}

}
