package com.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.domain.employee;
import com.domain.product;
import com.liu.CategoryService;
import com.liu.ProductService;

public class ProductTimerTask extends TimerTask{
	private ProductService productService;
	private CategoryService categoryService;
	private ServletContext application=null;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setApplication(ServletContext application){
		this.application=application;
	}
	
	public void run() {
		System.out.println("----run----");
		List<List<product>> bigList=new ArrayList<List<product>>();
		for(employee employee1:categoryService.queryByHot(true)){
			List<product> lst=productService.queryByemployeeId(employee1.getEid());
			bigList.add(lst);
		}
		application.setAttribute("bigList", bigList);
	}
	

}
