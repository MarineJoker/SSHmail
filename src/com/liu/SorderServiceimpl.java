package com.liu;

import java.util.List;

import com.domain.forder;
import com.domain.product;
import com.domain.sorder;
import com.domain.users;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import freemarker.core.ReturnInstruction.Return;
import sun.print.resources.serviceui;

public class SorderServiceimpl extends BaseServiceimpl<sorder> implements SorderService{

	@Override
	public forder addSorder(forder forders, product products) {
		boolean isHave=false;
		System.out.println("1");
		sorder sorders=productToSorder(products);
		System.out.println("2");
		System.out.println("forders:"+forders);
		System.out.println("3");
		for(sorder old:forders.getSorders()){
		if(old.getProduct1().getId().equals(sorders.getProduct1().getId())){
			old.setNumber(old.getNumber()+sorders.getNumber());
			System.out.println("old:"+old.getNumber());
			isHave=true;
			break;
		}
		System.out.println("4");
		System.out.println("old:"+old.getNumber());
		
	}
		System.out.println(isHave);
		if(!isHave)
		{
			sorders.setForder1(forders);
			forders.getSorders().add(sorders);
		}
		System.out.println("3");
		return forders;
	}

	@Override
	public forder updataSorder(sorder sorders, forder forders) {
		for(sorder temp:forders.getSorders()){
			if(temp.getProduct1().getId().equals(sorders.getProduct1().getId())){
				temp.setNumber(sorders.getNumber());
			}
		}
		return forders;
	}

	@Override
	public List<Object> querySale(int number) {
		System.out.println("number"+number);
		String hql="select name,sum(number) from sorder group by product1.id,name";
		return getSession().createQuery(hql).setFirstResult(0).setMaxResults(number).list();
	}

	@Override
	public sorder productToSorder(product products) {
		sorder sorders=new sorder();
		sorders.setName(products.getName());
		sorders.setNumber(1);
		sorders.setPrice(products.getPrice());
		sorders.setProduct1(products);
		return sorders;
	}

}
