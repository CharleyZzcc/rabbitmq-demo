
 /**
 * FileName:     DruidDataSourceSettings.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-01 23:05:53  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-01   lzc         1.0         1.0 Version  
 */

@Component
@ConfigurationProperties(prefix="spring.datasource")
@PropertySource("classpath:druid.properties")
@Data
public class DruidDataSourceSettings {

	private String driverClassName;
	
	private String url;
	
	private String username;
	
	private String password;
	
	@Value("${druid.initialSize}")
    private int initialSize;
     
    @Value("${druid.minIdle}")
    private int minIdle;
     
    @Value("${druid.maxActive}")
    private int maxActive;
     
    @Value("${druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
     
    @Value("${druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
     
    @Value("${druid.validationQuery}")
    private String validationQuery;
     
    @Value("${druid.testWhileIdle}")
    private boolean testWhileIdle;
     
    @Value("${druid.testOnBorrow}")
    private boolean testOnBorrow;
     
    @Value("${druid.testOnReturn}")
    private boolean testOnReturn;
     
    @Value("${druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;
     
    @Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
     
    @Value("${druid.filters}")
    private String filters;
     
    @Value("${druid.connectionProperties}")
    private String connectionProperties;
    
}
