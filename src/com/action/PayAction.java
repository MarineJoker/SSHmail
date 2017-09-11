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
        //1. 补全参数:P2 p3 pd Pa，需要从session中获取
    	SendData sendData=(SendData)model;
        forder forder = (forder) session.get("oldforder");
        users user = (users) session.get("user");
        sendData.setP2_Order(forder.getId().toString()); //商户订单号
        sendData.setP3_Amt(Double.toString(forder.getTotal())); //支付金额
        sendData.setPa_MP(user.getEmail() + "," + user.getPhone()); //商户扩展信息
        //2. 对参数进行追加        
        //3. 加密获取签名     
        //4. 存储到request域中
        payService.saveDataToRequest(request, sendData); //2,3,4的业务逻辑交给service层来处理
        //5. 跳转到支付页面       
        
        return "pay";
    }

	public void backBank() {
		BackData backData = (BackData)model;
		System.out.println(model);
		boolean isOK = payService.checkBackData(backData);
		if(isOK) {
			//1. 更新订单状态,参数是自己根据数据库中的情况传进去的，用来测试
			forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 1);
			//2. 根据user邮箱地址，发送邮件
			String emailAddress = backData.getR8_MP().split(",")[0];
			emailUtil.sendEmail(emailAddress, backData.getR6_Order());
//			//3. 发送手机短信
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