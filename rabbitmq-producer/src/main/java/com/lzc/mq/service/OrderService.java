
 /**
 * FileName:     OrderService.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzc.mq.constant.Constants;
import com.lzc.mq.entity.BrokerMessageLog;
import com.lzc.mq.entity.Orders;
import com.lzc.mq.mapper.BrokerMessageLogMapper;
import com.lzc.mq.mapper.OrderMapper;
import com.lzc.mq.producer.OrderSender;
import com.lzc.mq.utils.DateUtils;
import com.lzc.mq.utils.JsonUtil;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-05 15:06:40  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-05   lzc         1.0         1.0 Version  
 */

@Service
@Transactional
public class OrderService {

	@Autowired
    private OrderMapper orderMapper;
     
    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
     
    @Autowired
    private OrderSender orderSender;
     
    /**
    * <p>描述：创建订单</p>
    * @param orders
    * @throws Exception
    * @author lzc
     */
    public void createOrder(Orders orders) throws Exception {
        // 插入业务数据
        orderMapper.insert(orders);
        // 插入消息记录表数据
        BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
        // 消息唯一ID
        brokerMessageLog.setMessageId(orders.getMessageId());
        // 保存消息整体 转为JSON 格式存储入库
        brokerMessageLog.setMessage(JsonUtil.parseObject2Json(orders));
         // 设置消息状态为0 表示发送中
        brokerMessageLog.setStatus("0");
        // 使用当前时间当做订单创建时间（为了模拟一下简化）
        Date orderTime = new Date();
        brokerMessageLog.setCreateTime(orderTime);
        brokerMessageLog.setUpdateTime(orderTime);
        // 设置消息未确认超时时间窗口为 一分钟 
        brokerMessageLog.setNextRetry(DateUtils.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
        brokerMessageLogMapper.insert(brokerMessageLog);
        // 发送消息
        orderSender.send(orders);
    }
}
