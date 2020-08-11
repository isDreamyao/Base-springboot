package com.example.config.dataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-06-28 15:12
 * @description
 */
@Slf4j
//@Component
public class DefaultSpringDataSource implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update tf_b_repair_station set REPAIR_ID = 99996666 where id = 11015");
        int i = preparedStatement.executeUpdate();
        System.out.println("line number :  " + i);
    }

}


