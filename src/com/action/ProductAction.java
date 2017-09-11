package com.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.domain.product;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends BaseAction<product>{


	public String queryJoinCategory(){
		System.out.println("name"+model.getName());
		   System.out.println("page：" + page);
		System.out.println("rows"+rows);
		pageMap=new HashMap<String,Object>();
		List<product> productList=productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows",productList);
		Long total=productService.getCount(model.getName());
		pageMap.put("total", total);
		return "jsonMap";
	}
	public String deleteByIds(){
		System.out.println(ids);
		productService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
				
	}
	public void save() throws Exception{
		System.out.println("调用savel !");
		String pic=fileUpload.uploadFile(fileImage);
		System.out.println("pic:"+pic);
		model.setPic(pic);
		System.out.println("model的值"+model);
		model.setDate(new Date());
		System.out.println("name:"+model.getName());
		System.out.println("employee1:"+model.getEmployee1());
		productService.save(model);
	}
	public void update() throws Exception{
		String pic=fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Date());
		System.out.println(model);
		productService.update(model);
		
	}
	public String get(){
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
}
