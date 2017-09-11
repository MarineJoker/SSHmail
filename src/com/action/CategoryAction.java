package com.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.management.Query;
import javax.websocket.Session;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.domain.account;
import com.domain.employee;
import com.liu.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.media.sound.AlawCodec;

public class CategoryAction extends BaseAction<employee> {
	
	public String queryJoinAccount(){
	pageMap=new HashMap<String,Object>();
	List<employee> employees=categoryService.queryJoinAccount(model.getType(), page, rows);
	pageMap.put("rows", employees);
	Long total=categoryService.getCount(model.getType());
	pageMap.put("total", total);
	return "jsonMap";
	}
	public String  deleteByIds(){
		System.out.println(ids);
		categoryService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	public void save(){
		System.out.println(model);
		categoryService.save(model);
	}
	public void update(){
		System.out.println("调用了update");
		System.out.println("model:"+model);
//		model.setEid(2);
		System.out.println("hot"+model.getHot());
		System.out.println(model.getAccount1().getLogin());
		System.out.println("edi:"+model.getEid());
		categoryService.update(model);
	}
//	protected List<account> jsonList=null;
//	
//	public List<account> getA() {
//		return jsonList;
//	}
	public String  query(){
		System.out.println("调用query");
		jsonList=categoryService.query();
		System.out.println("jsonList:"+jsonList);
		return "jsonList";
	}
//	public String query1(){
//		jsonList=accountService.query();
//
//		System.out.println(jsonList);
//		return "jsonList";
//	}
	

}
