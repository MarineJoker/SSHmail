package com.liu;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtilimpl implements EmailUtil
{

	@Override
	public void sendEmail(String emailAddress, String id) {
		Properties prop=new Properties();
		Session session=null;
		Message message=null;
		Transport transport=null;
		try{
			prop.setProperty("mail.transport.protocol", "smtp");
			session=Session.getDefaultInstance(prop);
			session.setDebug(true);
			message=new MimeMessage(session);
			message.setSubject("�����̳Ƕ�������");
			message.setContent("�˿����ã���ӭ����������̳ǣ�����" + id + "��֧���ɹ���", "text/html;charset=utf-8");
			message.setFrom(new InternetAddress("83428190@qq.com"));
			transport=session.getTransport();
			transport.connect("smtp.qq.com","83428190","mypassword");
			transport.sendMessage(message, new InternetAddress[]{new InternetAddress(emailAddress)});
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally
		{
			try{
				transport.close();
			}catch (MessagingException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
	}

}
