package com.example.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.sql.DataSource;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-04-15 10:25
 * @description
 */
@Slf4j
//@Configuration
public class DruidDataSourceConfig {

    //    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource() {
        DruidDataSource build = new DruidDataSource();
//        DataSource build = DataSourceBuilder.create().type(DruidDataSource.class).build();
        return build;
    }


//    @Bean
//    @ConfigurationProperties("spring.datasource.druid")
//    public DataSource dataSource() {
//        DruidDataSource build = new DruidDataSource();
//        return build;
//    }

}


