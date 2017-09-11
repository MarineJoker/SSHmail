package com.domain;

import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;

public class product {
	private Integer id;
	private employee employee1;
	private String name;
	private double price;
	private String pic;
	private String remark;
	private String xremark;
	private Date date;
	private Boolean commend;
	private Boolean open1;
	public product(){
		
	}
	public product(employee employee1, String name, double price, String pic, String remark, String xremark, Date date,
			Boolean commend, Boolean open1) {
		super();
		this.employee1 = employee1;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.remark = remark;
		this.xremark = xremark;
		this.date = date;
		this.commend = commend;
		this.open1 = open1;
	}
	public product(Integer id, String name, double price, String pic,
			String remark, String xremark, Boolean commend, Boolean open1) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.remark = remark;
		this.xremark = xremark;
		this.commend = commend;
		this.open1 = open1;
	}
	@Override
	public String toString() {
		return "product [id=" + id + ", employee1=" + employee1 + ", name=" + name + ", price=" + price + ", pic=" + pic
				+ ", remark=" + remark + ", xremark=" + xremark + ", date=" + date + ", commend=" + commend + ", open1="
				+ open1 + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public employee getEmployee1() {
		return employee1;
	}
	public void setEmployee1(employee employee1) {
		this.employee1 = employee1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getXremark() {
		return xremark;
	}
	public void setXremark(String xremark) {
		this.xremark = xremark;
	}

	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getCommend() {
		return commend;
	}
	public void setCommend(Boolean commend) {
		this.commend = commend;
	}
	public Boolean getOpen1() {
		return open1;
	}
	public void setOpen1(Boolean open1) {
		this.open1 = open1;
	}


	

}
