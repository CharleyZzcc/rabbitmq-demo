
 /**
 * FileName:     OrderMapper.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.mapper;

import org.apache.ibatis.annotations.Param;

import com.lzc.mq.entity.Orders;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-05 15:09:29  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-05   lzc         1.0         1.0 Version  
 */

public interface OrderMapper {

	/**
	* <p>描述：</p>
	* @param orders
	* @author lzc
	*/
	void insert(@Param("orders") Orders orders);

}
