
 /**
 * FileName:     TaskSchedulerConfig.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.config.task;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-01 23:29:21  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-01   lzc         1.0         1.0 Version  
 */

@Configuration
@EnableScheduling
public class TaskSchedulerConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskScheduler());
	}

	@Bean(destroyMethod="shutdown")
	public Executor taskScheduler() {
		return Executors.newScheduledThreadPool(100);
	}
}
