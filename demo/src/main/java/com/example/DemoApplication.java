package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.CharacterEncodingFilter;

@Slf4j
//@MapperScan({"com.example.mapper"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@PropertySource(value = {"classpath:configuration/config/dev-private.properties"}, encoding = "utf-8")

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        log.info("========== StartApplication启动成功 =========");
    }

    @Bean
    public CharacterEncodingFilter initializeCharacterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

}
