package com.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class forder {

	private Integer id;
	private String name;
	private String phone;
	private String remark;
	private Date timestamp;
	private double total;
	private String post;
	private String address;
	private users uid;
	private status sid;
	private List<sorder> sorders;

	public forder(ArrayList<sorder> sorders) {
		super();
		this.sorders=sorders;
		
	}
	public forder() {
		
	}
	public List<sorder> getSorders() {
		return sorders;
	}
	public void setSorders(List<sorder> sorders) {
		this.sorders = sorders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public users getUid() {
		return uid;
	}
	public void setUid(users uid) {
		this.uid = uid;
	}
	public status getSid() {
		return sid;
	}
	public void setSid(status sid) {
		this.sid = sid;
	}
//	@Override
//	public String toString() {
//		return "forder [id=" + id + ", name=" + name + ", phone=" + phone + ", remark=" + remark + ", timestamp="
//				+ timestamp + ", total=" + total + ", post=" + post + ", address=" + address + ", uid=" + uid + ", sid="
//				+ sid + ", sorders=" + sorders + "]";
//	}
}
