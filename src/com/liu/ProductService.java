package com.liu;

import java.util.List;

import com.domain.product;

public interface ProductService extends BaseService<product>{
	public List<product> queryJoinCategory(String name,int page,int size);
	public Long getCount(String name);
	public void deleteByIds(String ids);
	public List<product> queryByemployeeId(int cid);
	
}
