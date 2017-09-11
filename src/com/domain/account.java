package com.domain;

import java.util.HashSet;
import java.util.Set;

public class account {
	private int id;
	private String login;
	private String name;
	private String pass;
	private Set<employee> set=new HashSet<employee>();
	public account(){
		
	}

//	public account(String login, String name, String pass) {
//		super();
//		this.login = login;
//		this.name = name;
//		this.pass = pass;
//	}
	@Override
	public String toString() {
		return "account [id=" + id + ", login=" + login + ", name=" + name + ", pass=" + pass + ", set=" + set + "]";
	}
	public Set<employee> getSet() {
		return set;
	}
	public void setSet(Set<employee> set) {
		this.set = set;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
