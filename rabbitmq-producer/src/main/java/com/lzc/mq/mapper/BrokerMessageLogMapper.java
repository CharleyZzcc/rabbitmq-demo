
 /**
 * FileName:     BrokerMessageLogMapper.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lzc.mq.entity.BrokerMessageLog;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-01 23:36:06  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-01   lzc         1.0         1.0 Version  
 */

public interface BrokerMessageLogMapper {

	/**
	* <p>描述：查询消息状态为0(发送中) 且已经超时的消息集合</p>
	* @return
	* @author lzc
	 */
    List<BrokerMessageLog> query4StatusAndTimeoutMessage();
     
    /**
    * <p>描述：重新发送统计count发送次数 +1</p>
    * @param messageId
    * @param updateTime
    * @author lzc
     */
    void update4ReSend(@Param("messageId")String messageId, @Param("updateTime")Date updateTime);
    
    /**
    * <p>描述：更新最终消息发送结果 成功 or 失败</p>
    * @param messageId
    * @param status
    * @param updateTime
    * @author lzc
     */
    void changeBrokerMessageLogStatus(@Param("messageId")String messageId, @Param("status")String status, @Param("updateTime")Date updateTime);

	/**
	* <p>描述：</p>
	* @param brokerMessageLog
	* @author lzc
	*/
	void insert(@Param("brokerMessageLog")BrokerMessageLog brokerMessageLog);
}
