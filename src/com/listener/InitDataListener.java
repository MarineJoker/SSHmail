package com.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.domain.employee;
import com.domain.product;
import com.liu.CategoryService;
import com.liu.CategoryServiceimpl;
import com.liu.FileUpload;
import com.liu.ProductService;
import com.utils.ProductTimerTask;

import antlr.debug.Event;

public class InitDataListener implements ServletContextListener{
//	private ProductService productService=null;
//	private CategoryService categoryService=null;
	private WebApplicationContext context=null;
	private ProductTimerTask productTimerTask=null;
	private FileUpload fileUpload=null;
//	private ApplicationContext context=null;
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}
	public void contextInitialized(ServletContextEvent event){
		  context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());          
		  productTimerTask=(ProductTimerTask) context.getBean("productTimerTask");
		  productTimerTask.setApplication(event.getServletContext());
		  new Timer(true).schedule(productTimerTask, 0, 1000*3*60);
		  fileUpload = (FileUpload) context.getBean("fileUpload");
	        event.getServletContext().setAttribute("bankImageList", fileUpload.getBankImage());
//	        categoryService = (CategoryService) context.getBean("categoryService");//加载类别信息          
//	        productService = (ProductService) context.getBean("productService");//加载商品信息 
//	        List<List<product>> bigList=new ArrayList<List<product>>();
//	        for(employee employee1:categoryService.queryByHot(true)){
//	        	List<product> lst=productService.queryByemployeeId(employee1.getEid());
//	        	bigList.add(lst);
//	        }
//	        event.getServletContext().setAttribute("bigList", bigList);
	        
	}
	
	 
	


}
