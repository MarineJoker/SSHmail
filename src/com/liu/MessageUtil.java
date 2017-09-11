package com.liu;

import org.apache.coyote.http11.filters.VoidInputFilter;

public interface MessageUtil {
	public abstract void sendMessage(String phoneNum,String id);

}
