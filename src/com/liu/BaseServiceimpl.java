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
		    System.out.println("this������ǵ�ǰ���ù��췽���Ķ���" + this);  
	        System.out.println("��ȡ��ǰthis����ĸ�����Ϣ" + this.getClass().getSuperclass());  
	        System.out.println("��ȡ��ǰthis����ĸ�����Ϣ(����������Ϣ)" + this.getClass().getGenericSuperclass());  
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
		System.out.println("����get����");
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		System.out.println("query()");
		String hql="from "+clazz.getName();
		return getSession().createQuery(hql).list();
	}
	

}
