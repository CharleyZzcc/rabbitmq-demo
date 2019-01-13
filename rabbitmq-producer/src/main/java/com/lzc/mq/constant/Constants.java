
 /**
 * FileName:     Constants.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.constant;


/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-01 23:34:21  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-01   lzc         1.0         1.0 Version  
 */

public class Constants {

	/** 发送中 */
	public static final String ORDER_SENDING = "0";
	/** 成功 */
    public static final String ORDER_SEND_SUCCESS = "1";
    /** 失败 */
    public static final String ORDER_SEND_FAILURE = "2";
    /** 分钟超时单位：min */
    public static final int ORDER_TIMEOUT = 1;
}
