package com.liu;

import com.domain.forder;

public interface ForderService extends BaseService<forder>{
	public double cluTotal(forder forders);
	public void updateStatusById(int id,int sid);
}
