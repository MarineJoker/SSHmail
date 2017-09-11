package com.action;

import java.util.Date;

import com.domain.forder;
import com.domain.status;
import com.domain.users;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ForderAction extends BaseAction<forder>{

	public forder getModel(){
		model=(forder)session.get("forder");
		return model;
	}
	public String save(){
		model.setUid((users)session.get("user"));
		model.setTimestamp(new Date());
		model.setSid(new status(1));
		forderService.save(model);
		session.put("oldforder",session.get("forder"));
		session.put("forder", new forder());
		return "bank";
	}
}
