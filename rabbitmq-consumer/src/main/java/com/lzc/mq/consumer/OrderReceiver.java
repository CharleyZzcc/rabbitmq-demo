
 /**
 * FileName:     OrderReceiver.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.consumer;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.lzc.mq.entity.Orders;
import com.rabbitmq.client.Channel;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-01 17:01:26  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-01   lzc         1.0         1.0 Version  
 */

@Component
public class OrderReceiver {

	//@RabbitListener可以自动添加队列、交换机与routingKey，并将队列和交换机绑定
	@RabbitListener(bindings = @QueueBinding(
				value = @Queue(value="orders-queue", durable="true"),
				exchange = @Exchange(name="orders-exchange", durable="true", type="topic"),
				key = "orders.#"
			)
	)
	@RabbitHandler
	public void onOrderMessage(@Payload Orders orders, @Headers Map<String, Object> headers, 
			Channel channel) throws IOException {
		
		//消费者操作
		System.out.println("====收到消息，开始消费====");
		System.out.println("订单id:"+ orders.getId());
		
		long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
		
		//ACK 手工签收，通知消息中心，消费者已收到消息
		channel.basicAck(deliveryTag, false);
	}
}
