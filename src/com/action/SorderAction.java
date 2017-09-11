package com.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.domain.forder;
import com.domain.product;
import com.domain.sorder;
import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class SorderAction extends BaseAction<sorder>{
	public String addSorder(){
		System.out.println("调用products");
		System.out.println("model"+model);
		System.out.println("id"+model.getProduct1().getId());
		product products=productService.get(model.getProduct1().getId());
		System.out.println(products.getName());
		System.out.println("调用products结束");
		if(session.get("forder")==null){
			 session.put("forder", new forder(new ArrayList<sorder>())); 
		}
		 forder forders=(forder) session.get("forder");
		 System.out.println("forders:"+forders);
		 forders=sorderService.addSorder(forders, products);
		 forders.setTotal(forderService.cluTotal(forders));
		 return "showCart";
	}
	public String updateSorder(){
		forder forders=(forder)session.get("forder");
		forders=sorderService.updataSorder(model,forders);
		forders.setTotal(forderService.cluTotal(forders));
		session.put("forde", forders);
		inputStream=new ByteArrayInputStream(Double.toString(forders.getTotal()).getBytes());
		return "stream";
	}
	public String querySale(){
		List<Object> jsonList=sorderService.querySale(model.getNumber());
		System.out.println("jsonList"+jsonList.size());
		System.out.println("jsonList"+jsonList.get(0).getClass());
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
}
