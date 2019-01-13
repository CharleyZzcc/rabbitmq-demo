
 /**
 * FileName:     DateUtils.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-05 15:17:00  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-05   lzc         1.0         1.0 Version  
 */

public class DateUtils {

	/**
	* <p>描述：</p>
	* @param time
	* @param amount
	* @return
	* @author lzc
	*/
	public static Date addMinutes(Date time, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(Calendar.MINUTE, amount);
		return cal.getTime();
	}

}
