package com.liu;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestBindingException;

import com.domain.employee;

public class CategoryServiceimpl extends BaseServiceimpl<employee>implements CategoryService {

	@Override
	public List<employee> queryJoinAccount(String type,int page,int size) {
		String hql="from employee where type like :type";
		return getSession().createQuery(hql).setString("type", "%"+type+"%").setFirstResult((page-1)*size).setMaxResults(size).list();
	}

	@Override
	public Long getCount(String type) {
		String hql="select count(*) from employee where type like :type";
		return (Long) getSession().createQuery(hql).setString("type", "%"+type+"%").uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String  hql="delete from employee where id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();
		
	}

	@Override
	public List<employee> queryByHot(boolean hot) {
		String hql="from employee where hot=:hot";
		return getSession().createQuery(hql).setBoolean("hot", hot).list();
	}





	
}
