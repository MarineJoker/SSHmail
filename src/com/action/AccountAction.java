package com.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

import com.domain.account;
import com.domain.employee;
import com.liu.AccountService;
import com.sun.org.apache.bcel.internal.generic.AALOAD;

public class AccountAction extends BaseAction<account> { 
	protected List<account> a=null;
	
	public List<account> getA() {
		return a;
	}
	public String  query(){
		System.out.println("µ÷ÓÃquery()");
		jsonList=accountService.query();
		System.out.println("jsonList:"+jsonList);
		System.out.println("type:"+jsonList.get(0).getLogin());
		return "jsonList";
	}
	
}
