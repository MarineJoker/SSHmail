package com.liu;

import java.util.Map;

import com.domain.BackData;
import com.domain.SendData;

public interface PayService {
	public abstract Map<String, Object> saveDataToRequest(
            Map<String, Object> request, SendData sendData);

    //�ѷ��ص����ݽ��м��ܵõ����ģ����봫���������ıȽϣ������Ǻ�������ʵ�֣�
    public boolean checkBackData(BackData backData);
}
