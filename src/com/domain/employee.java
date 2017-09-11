package com.domain;

import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class employee {
	private int eid;
	private String type;
	private Boolean hot;
	private account account1;
	public employee(){
	
	}
//	public employee(account account1,String type,String hot){
//		this.account1 = account1;
//		this.type = type;
//		this.hot = hot;
//	}
//	@Override
//	public String toString() {
//		return6 "employee [eid=" + eid + ", type=" + type + ", hot=" + hot + ", account1=" + account1 + "]";
//	}
//	public employee(int eid, String type, String hot) {
//		super();
//		this.eid = eid;
//		this.type = type;
//		this.hot = hot;
//	}
//	public employee(String type,String hot){
//		super();
//		this.type=type;
//		this.hot=hot;
//	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Boolean getHot() {
		return hot;
	}
	public void setHot(Boolean hot) {
		this.hot = hot;
	}
	public account getAccount1() {
		return account1;
	}
	public void setAccount1(account account1) {
		this.account1 = account1;
	}
	

	

}
