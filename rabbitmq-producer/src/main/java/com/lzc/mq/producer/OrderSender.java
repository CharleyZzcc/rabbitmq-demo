
 /**
 * FileName:     OrderSender.java
 * Copyright (c) 2018 lzc.All Rights Reserved.
 */

package com.lzc.mq.producer;

import java.util.Date;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lzc.mq.constant.Constants;
import com.lzc.mq.entity.Orders;
import com.lzc.mq.mapper.BrokerMessageLogMapper;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2018-12-23 22:37:19  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2018-12-23   lzc         1.0         1.0 Version  
 */

@Component
public class OrderSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
	
//	/**
//	* <p>描述：发送订单消息</p>
//	* @param orders
//	* @author lzc
//	 */
//	public void send(Orders orders) {
//		
//		CorrelationData correlationData = new CorrelationData(orders.getMessageId());
//		rabbitTemplate.convertAndSend("orders-exchange",	//订单交换机
//				"orders.abcd",	//routingKey
//				orders,	//消息体内容
//				correlationData);	//消息唯一标识
//	}
	
	/**
	 * 回调函数
	 */
	final ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
		
		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			System.err.println("correlationData:" + correlationData);
			
			String messageId = correlationData.getId();
			if(ack) {
				//如果confirm返回成功，则进行更新
				brokerMessageLogMapper.changeBrokerMessageLogStatus(messageId, Constants.ORDER_SEND_SUCCESS, new Date());
			}else {
				//失败则进行后续操作：如重试、补偿等手段 TODO
				System.err.println("confirm返回失败的异常处理...");
			}
		}
	};
	
	/**
	 * <p>描述：发送订单消息</p>
	 * @param orders
	 * @author lzc
	 */
	public void send(Orders orders) {
		rabbitTemplate.setConfirmCallback(confirmCallback);
		
		CorrelationData correlationData = new CorrelationData(orders.getMessageId());
		rabbitTemplate.convertAndSend("orders-exchange1",	//订单交换机
				"orders.ABC",	//routingKey
				orders,	//消息体内容
				correlationData);	//消息唯一标识
	}
}
