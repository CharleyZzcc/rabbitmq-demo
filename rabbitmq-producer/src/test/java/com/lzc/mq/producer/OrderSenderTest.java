
 /**
 * FileName:     OrderSenderTest.java
 * Copyright (c) 2018 lzc.All Rights Reserved.
 */

package com.lzc.mq.producer;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lzc.mq.entity.Orders;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2018-12-23 22:44:36  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2018-12-23   lzc         1.0         1.0 Version  
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSenderTest {

	@Autowired
	private OrderSender orderSender;
	
	@Test
	public void testSender() {
		Orders orders = new Orders();
		orders.setId("201901050000000001");
		orders.setName("测试新年订单1");
		orders.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
		orderSender.send(orders);
	}
	
}
