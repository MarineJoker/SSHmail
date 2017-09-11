package com.liu;

import java.util.List;

import com.domain.users;

public class UsersServiceimpl extends BaseServiceimpl<users> implements UsersService {

	@Override
	public users login(users user) {
		String hql="from users where login=:login and pass=:pass";
		return (users) getSession().createQuery(hql).setString("login", user.getLogin()).setString("pass",user.getPass()).uniqueResult();
	}

}
