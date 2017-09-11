package com.liu;

import java.util.List;

import com.domain.employee;

public interface CategoryService extends BaseService<employee>{
	public List<employee> queryJoinAccount(String type,int page,int size);
	public Long getCount(String type);
	public void deleteByIds(String ids);
	public List<employee> queryByHot(boolean hot);

}
