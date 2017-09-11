package com.domain;

public class sorder {
	private Integer id;
	private String name;
	private double  price;
	private Integer number;
	private product product1;
	private forder forder1;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public product getProduct1() {
		return product1;
	}
	public void setProduct1(product product1) {
		this.product1 = product1;
	}
	public forder getForder1() {
		return forder1;
	}
	public void setForder1(forder forder1) {
		this.forder1 = forder1;
	}



	
}
