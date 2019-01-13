
 /**
 * FileName:     MybatisMapperScanerConfig.java
 * Copyright (c) 2019 lzc.All Rights Reserved.
 */

package com.lzc.mq.config.database;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:   
 * @author:     lzc  
 * @version:    1.0  
 * @date:       2019-01-01 23:24:25  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2019-01-01   lzc         1.0         1.0 Version  
 */

@Configuration
@AutoConfigureAfter(MybatisDataSourceConfig.class)
public class MybatisMapperScanerConfig {

	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.lzc.mq.mapper");
        return mapperScannerConfigurer;
    }
}
