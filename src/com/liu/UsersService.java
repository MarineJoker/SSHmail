package com.liu;

import com.domain.users;

public interface UsersService extends BaseService<users>{
	public users login(users user);
}
