package com.liu;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.usertype.DynamicParameterizedType.ParameterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

public class BaseServiceimpl<T> implements BaseService<T> {

	private Class clazz;
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 public BaseServiceimpl() {
		    System.out.println("this代表的是当前调用构造方法的对象" + this);  
	        System.out.println("获取当前this对象的父类信息" + this.getClass().getSuperclass());  
	        System.out.println("获取当前this对象的父类信息(包括泛型信息)" + this.getClass().getGenericSuperclass());  
	        ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
	        clazz=(Class)type.getActualTypeArguments()[0];
	}
	 protected Session getSession(){
		 return sessionFactory.getCurrentSession();
	 }
	@Override
	public  void save(T t) {
		getSession().save(t);
		
	}

	@Override
	public void update(T t) {
		
		getSession().update(t);
		
	}

	@Override
	public void delete(int id) {
		System.out.println(clazz.getSimpleName());
		System.out.println("id");
		String hql="delete"+clazz.getSimpleName()+"as c where c.id=:id";
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
		
		
	}

	@Override
	public T get(int id) {
		System.out.println("调用get方法");
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		System.out.println("query()");
		String hql="from "+clazz.getName();
		return getSession().createQuery(hql).list();
	}
	

}
