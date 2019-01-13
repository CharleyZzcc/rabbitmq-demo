
 /**
 * FileName:     RetryMessageTasker.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.task;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lzc.mq.constant.Constants;
import com.lzc.mq.entity.BrokerMessageLog;
import com.lzc.mq.entity.Orders;
import com.lzc.mq.mapper.BrokerMessageLogMapper;
import com.lzc.mq.producer.OrderSender;
import com.lzc.mq.utils.JsonUtil;

/**
 * Description: 重发消息定时器  
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-05 15:33:23  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-05   lzc         1.0         1.0 Version  
 */
@Component
public class RetryMessageTasker {

	@Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
     
    @Autowired
    private OrderSender orderSender;
    
    /**
    * <p>描述：重发消息定时任务</p>
    * @author lzc
     */
    @Scheduled(initialDelay=5000, fixedDelay=10000)
    public void resend() {
    	List<BrokerMessageLog> list = brokerMessageLogMapper.query4StatusAndTimeoutMessage();
    	if(list!=null && !list.isEmpty()) {
    		list.forEach(msgLog -> {
    			if(msgLog.getTryCount() >= 3) {
    				//更新失败消息
    				brokerMessageLogMapper.changeBrokerMessageLogStatus(msgLog.getMessageId(), 
    						Constants.ORDER_SEND_FAILURE, new Date());
    			}else {
    				//重发
    				brokerMessageLogMapper.update4ReSend(msgLog.getMessageId(), new Date());
    				Orders resendOrders = JsonUtil.parseJson2Object(msgLog.getMessage(), Orders.class);
    				try {
						orderSender.send(resendOrders);
					} catch (Exception e) {
						e.printStackTrace();
						//TODO
						System.err.println("定时任务异常处理...");
					}
    			}
    		});
    	}
    }
}
