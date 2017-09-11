package com.domain;

import java.util.HashSet;
import java.util.Set;

public class status {
	Integer id;
	String status;
	private Set<forder> forders = new HashSet<forder>(0);
	public status(int id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public Set<forder> getForders() {
		return forders;
	}
	public void setForders(Set<forder> forders) {
		this.forders = forders;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	@Override
//	public String toString() {
//		return "status [id=" + id + ", status=" + status + ", forders=" + forders + "]";
//	}

	
}
