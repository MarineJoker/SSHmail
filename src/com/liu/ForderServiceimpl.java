package com.liu;

import com.domain.forder;
import com.domain.sorder;

public class ForderServiceimpl extends BaseServiceimpl<forder> implements ForderService{

	@Override
	public double cluTotal(forder forders) {
		double total=0.0;
		for(sorder sorders:forders.getSorders()){
			total+=sorders.getNumber()*sorders.getPrice();
			
		}
		System.out.println("total"+total);
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		String hql="update forder set sid.id=:sid where id=:id";
		getSession().createQuery(hql).setInteger("sid", sid).setInteger("id", id).executeUpdate();
		
	}
	

	
}
