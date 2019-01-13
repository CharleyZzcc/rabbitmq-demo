
 /**
 * FileName:     BrokerMessageLog.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-01 23:02:13  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-01   lzc         1.0         1.0 Version  
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrokerMessageLog {

	private String messageId;
	 
    private String message;
 
    private Integer tryCount;
 
    private String status;
 
    private Date createTime;
 
    private Date updateTime;
    
    private Date nextRetry;
}
