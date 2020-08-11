package com.example.config.dataSource.multiDataSourceConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-07-22 8:58
 * @description
 */
@Configuration
public class SpringJdbcMultipleDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource readDataSource() {
        return new DruidDataSource();
//        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.copy.druid")
    public DataSource writeDataSource() {
        return new DruidDataSource();
//        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSource dataSourceConfig(DataSource readDataSource, DataSource writeDataSource) {
        Map<Object, Object> map = new HashMap<>();
        map.put(DataSourceNames.read, readDataSource);
        map.put(DataSourceNames.write, writeDataSource);
        return new DynamicDataSourceConfig(readDataSource, map);
    }

}


