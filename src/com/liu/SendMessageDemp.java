package com.liu;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

import sun.security.jgss.HttpCaller;

public class SendMessageDemp {
	public static void main(String[] args) throws HttpException, IOException {
		HttpClient client=new HttpClient();
		PostMethod post=new PostMethod("http://utf8.sms.webchinese.cn/");
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		post.setParameter("Uid", "liu83428190");
		post.setParameter("Key", "52917aa86e20f2b81af1");
		post.setParameter("smsMob", "15051704086");
		post.setParameter("smsText", "测试一下");
		int code=client.executeMethod(post);
		System.out.println("http"+code);
		String result=post.getResponseBodyAsString();
		System.out.println("短信发送结果为"+result);
	}

}
