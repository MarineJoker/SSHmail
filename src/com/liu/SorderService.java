package com.liu;

import java.util.List;

import com.domain.forder;
import com.domain.product;
import com.domain.sorder;
import com.domain.users;


public interface SorderService extends BaseService<sorder>{
	public forder addSorder(forder forders,product products);
	public sorder productToSorder(product products);
	public forder updataSorder(sorder sorders,forder forders);
	public List<Object> querySale(int number);
}
