package com.liu;

import java.util.Map;

import com.domain.BackData;
import com.domain.SendData;

public interface PayService {
	public abstract Map<String, Object> saveDataToRequest(
            Map<String, Object> request, SendData sendData);

    //把返回的数据进行加密得到密文，并与传回来的密文比较，（我们后面再来实现）
    public boolean checkBackData(BackData backData);
}
