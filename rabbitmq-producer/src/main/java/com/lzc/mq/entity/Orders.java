
 /**
 * FileName:     Order.java
 * Copyright (c) 2018 lzc.All Rights Reserved.
 */

package com.lzc.mq.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2018-12-23 22:34:30  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2018-12-23   lzc         1.0         1.0 Version  
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable{
	
	private static final long serialVersionUID = -1629865637835405956L;
	
	private String id;
	
	private String name;
	
	private String messageId;

}
