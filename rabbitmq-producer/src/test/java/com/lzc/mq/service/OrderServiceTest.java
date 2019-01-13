
 /**
 * FileName:     OrderServiceTest.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.service;

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
 * @date:       2019-01-05 16:22:42  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-05   lzc         1.0         1.0 Version  
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	
	@Test
	public void test() throws Exception {
		Orders orders = new Orders();
		orders.setId("201901050000000005");
		orders.setName("测试新年订单5");
		orders.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
		orderService.createOrder(orders);
	}

}
