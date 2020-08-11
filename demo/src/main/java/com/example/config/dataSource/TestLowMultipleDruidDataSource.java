package com.example.config.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-06-29 17:44
 * @description
 */
//@Component
@RequestMapping("/test")
public class TestLowMultipleDruidDataSource implements CommandLineRunner {


    @Autowired
    @Qualifier("oneData")
    private DataSource dataSource;

    @Autowired
    @Qualifier("twoData")
    private DataSource dataSourceTwo;

    @Override
    public void run(String... args) throws Exception {
//        int i = dataSource.getConnection().prepareStatement("update tf_b_repair_station set REPAIR_ID = 11 where id = 11015").executeUpdate();
//        System.out.println(i);
    }

    @RequestMapping("/test")
    @ResponseBody
    private void executeSql() throws SQLException {
        int i = dataSource.getConnection().prepareStatement("update tf_b_repair_station set REPAIR_ID = 444 where id = 11015").executeUpdate();
        System.out.println(i);
    }

    @RequestMapping("/test2")
    @ResponseBody
    private void executeSql2() throws SQLException {
        int i = dataSourceTwo.getConnection().prepareStatement("update tf_b_repair_station set REPAIR_ID = 444 where id = 11015").executeUpdate();
        System.out.println(i);
    }
}


