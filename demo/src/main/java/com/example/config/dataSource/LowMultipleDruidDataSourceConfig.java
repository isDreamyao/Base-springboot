//package com.example.dataSouceConfig;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * @author HuangHaiLong
// * @version 1.0
// * @date 2020-04-15 10:25
// * @description
// */
//@Slf4j
////@Configuration
//public class LowMultipleDruidDataSourceConfig {
//
//    @Primary
////    @Bean("oneData")
//    @ConfigurationProperties("spring.datasource.druid")
//    public DataSource dataSourceOne() {
//        DruidDataSource build = DataSourceBuilder.create().type(DruidDataSource.class).build();
//        return build;
//    }
//
//    //    @Bean("twoData")
//    @ConfigurationProperties("spring.datasource.druid.copy")
//    public DataSource dataSourceTwo(DataSource dataSourceOne) {
//        DruidDataSource build = new DruidDataSource();
//        return build;
//    }
//
//}
//
//
