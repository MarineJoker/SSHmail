package com.action;

import com.domain.users;
import com.liu.UsersService;

public class UserAction extends BaseAction<users>{

	public String login(){
		model=usersService.login(model);
		System.out.println("µ÷ÓÃlogin");
		if(model==null)
		{
			session.put("error", "µÇÂ½Ê§°Ü");
			return "login";
		}
		else
		{
			session.put("user",model);
			if(session.get("goURL")==null)
			{
				return "index";
			}
			else
			{
				return "goURL";
			}
		}
		
	}
	public String register(){
		users u=new users();
		u=model;
		System.out.println("u:"+u.getLogin());
		model=usersService.login(model);
		if(model==null){
			usersService.save(u);
			session.put("user", u);
			return "success";
		}
		else
		{
			return "failed";
		}
	}
}
