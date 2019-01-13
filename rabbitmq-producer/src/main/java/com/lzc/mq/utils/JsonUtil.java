
 /**
 * FileName:     JsonUtil.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.utils;

import com.alibaba.fastjson.JSON;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-05 15:12:21  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-05   lzc         1.0         1.0 Version  
 */

public class JsonUtil {

	/**
	* <p>描述：</p>
	* @param obj
	* @return
	* @author lzc
	 */
	public static String parseObject2Json(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	/**
	* <p>描述：</p>
	* @param json
	* @param Objclass
	* @return
	* @author lzc
	 */
	public static <T> T parseJson2Object(String json, Class<T> Objclass) {
		return JSON.parseObject(json, Objclass);
	}
}
