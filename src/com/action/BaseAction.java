package com.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.domain.FileImage;
import com.liu.AccountService;
import com.liu.CategoryService;
import com.liu.EmailUtil;
import com.liu.FileUpload;
import com.liu.ForderService;
import com.liu.MessageUtil;
import com.liu.PayService;
import com.liu.ProductService;
import com.liu.SorderService;
import com.liu.UsersService;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {  
	  
    //service对象
	protected String ids;
	protected InputStream inputStream;
	protected Integer page;
	protected Integer rows;
	protected Map<String, Object> pageMap=null;	
	protected List<T> jsonList=null; 
	protected FileImage fileImage;
	protected FileUpload fileUpload;
    protected CategoryService categoryService;  
    protected AccountService accountService;  
    protected ProductService productService;
    protected ForderService forderService;
    protected SorderService sorderService;
    protected UsersService usersService;
    protected PayService payService;
    protected EmailUtil emailUtil;
    protected MessageUtil messageUtil;
    
    public void setMessageUtil(MessageUtil messageUtil) {
		this.messageUtil = messageUtil;
	}
	public void setEmailUtil(EmailUtil emailUtil) {
		this.emailUtil = emailUtil;
	}
	public PayService getPayService() {
		return payService;
	}
	public void setPayService(PayService payService) {
		this.payService = payService;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	public void setForderService(ForderService forderService) {
		this.forderService = forderService;
	}
	public ForderService getForderService() {
		return forderService;
	}
	public SorderService getSorderService() {
		return sorderService;
	}
	public void setSorderService(SorderService sorderService) {
		this.sorderService = sorderService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setCategoryService(CategoryService categoryService) {  
        this.categoryService = categoryService;  
    }  
    public void setAccountService(AccountService accountService) {  
        this.accountService = accountService;  
    }  
	
	public FileUpload getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	public List<T> getJsonList() {
		return jsonList;
	}
	public FileImage getFileImage() {
		return fileImage;
	}
	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Map<String, Object> getPageMap() {
		return pageMap;
	}
    //域对象  
    protected Map<String, Object> request;  
    protected Map<String, Object> session;  
    protected Map<String, Object> application;  
          
    @Override  
    public void setApplication(Map<String, Object> application) {  
        this.application = application;  
    }  
    @Override  
    public void setSession(Map<String, Object> session) {  
        this.session = session;  
    }  
    @Override  
    public void setRequest(Map<String, Object> request) {  
        this.request = request;  
    }  
      
    //ModelDriven  
    protected T model;  
    @Override  
    public T getModel() {  
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();  
        Class clazz = (Class)type.getActualTypeArguments()[0];  
        try {  
            model = (T)clazz.newInstance();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }     
        return model;  
    }  
}  