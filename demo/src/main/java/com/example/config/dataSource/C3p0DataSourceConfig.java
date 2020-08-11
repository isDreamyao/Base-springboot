package com.example.config.dataSource;

import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-04-15 10:25
 * @description
 */
@Slf4j
//@Configuration
public class C3p0DataSourceConfig {

    //    @Bean
//    @ConfigurationProperties("c3p0")
    public DataSource c3p0DataSource() {
        return null;
//        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }

}


