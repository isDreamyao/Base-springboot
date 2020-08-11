package com.example;

import com.example.config.dataSource.multiDataSourceConfig.DataSourceAnnotation;
import com.example.config.dataSource.multiDataSourceConfig.DataSourceNames;
import com.example.config.properties.SelfProperties;
import com.example.mapper.DataBaseOperateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;

@Slf4j
//@MapperScan({"com.example.mapper"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication implements CommandLineRunner, ApplicationContextAware {

    ApplicationContext applicationContext2 = null;

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DataBaseOperateMapper dataBaseOperateMapper;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        log.info("========== StartApplication启动成功 =========");
    }

    @GetMapping("/test")
    public void testDataSourceWrite() {


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext2 = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {

        Object name = SelfProperties.PROPERTIES.get("name");
        Object work = SelfProperties.PROPERTIES.get("work");
        Object like = SelfProperties.PROPERTIES.get("like");

//        DataBaseOperateMapper bean = applicationContext2.getBean(DataBaseOperateMapper.class);


//        List<JSONObject> jsonObject = bean.selectOilStaion(null);


//        Connection connection = dataSource.getConnection();
//
//
//        List<JSONObject> jsonObjects = dataBaseOperateMapper.selectOilStation(new HashMap<>());
//
//
//        for (JSONObject jsonObject : jsonObjects) {
//
//        }
    }

    @DataSourceAnnotation(name = DataSourceNames.read)
    @GetMapping("/test")
    public void testDataSourceRead() {

    }

}
