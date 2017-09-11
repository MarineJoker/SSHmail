package com.liu;

import java.util.List;

import com.domain.product;

public class ProductServiceimpl extends BaseServiceimpl<product> implements ProductService {

	@Override
	public List<product> queryJoinCategory(String name, int page, int size) {
		String hql="from product where name like :name";
		return getSession().createQuery(hql).setString("name", "%"+name+"%").setFirstResult((page-1)*size).setMaxResults(size).list();
	}

	@Override
	public Long getCount(String name) {
		String hql="select count(*) from product where name like :name";
		
		return (Long)getSession().createQuery(hql).setString("name","%"+name+"%").uniqueResult() ;
	}

	public void deleteByIds(String ids) {
		String hql="delete from product where id in("+ids+")";
		getSession().createQuery(hql).executeUpdate();
		
	}

	@Override
	public List<product> queryByemployeeId(int cid) {
		String hql="from product where commend=true and open1=true and employee1.eid=:cid order by date desc";
		return getSession().createQuery(hql).setInteger("cid", cid).setFirstResult(0).setMaxResults(4).list();
	}
	


}
