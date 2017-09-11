package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;

import com.domain.BackData;
import com.domain.SendData;
import com.domain.forder;
import com.domain.users;
import com.sun.corba.se.spi.orb.StringPair;
import com.sun.org.apache.bcel.internal.generic.NEW;
public class PayAction extends BaseAction<Object> implements ParameterAware{

	private Map<String, String[]> parameters;
	public void setParameters(Map<String, String[]>parameters){
		this.parameters=parameters;
	}
	public Object getModel(){
		if(parameters.get("pd_FrpId")!=null)
		{
			model=new SendData();
		}
		else
		{
			model=new BackData();
		}
		return model;
		
	}
    public String goBank() {
        //1. ��ȫ����:P2 p3 pd Pa����Ҫ��session�л�ȡ
    	SendData sendData=(SendData)model;
        forder forder = (forder) session.get("oldforder");
        users user = (users) session.get("user");
        sendData.setP2_Order(forder.getId().toString()); //�̻�������
        sendData.setP3_Amt(Double.toString(forder.getTotal())); //֧�����
        sendData.setPa_MP(user.getEmail() + "," + user.getPhone()); //�̻���չ��Ϣ
        //2. �Բ�������׷��        
        //3. ���ܻ�ȡǩ��     
        //4. �洢��request����
        payService.saveDataToRequest(request, sendData); //2,3,4��ҵ���߼�����service��������
        //5. ��ת��֧��ҳ��       
        
        return "pay";
    }

	public void backBank() {
		BackData backData = (BackData)model;
		System.out.println(model);
		boolean isOK = payService.checkBackData(backData);
		if(isOK) {
			//1. ���¶���״̬,�������Լ��������ݿ��е��������ȥ�ģ���������
			forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 1);
			//2. ����user�����ַ�������ʼ�
			String emailAddress = backData.getR8_MP().split(",")[0];
			emailUtil.sendEmail(emailAddress, backData.getR6_Order());
//			//3. �����ֻ�����
			String phoneNum = backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(phoneNum, backData.getR6_Order());
			System.out.println("----success!!----");
//			return "index";
		} else {
			System.out.println("----false!!!----");
//			return "error";
		}
}
}