package com.example.config.dataSource.multiDataSourceConfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-07-22 9:06
 * @description
 */
public class DynamicDataSourceConfig extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<String>();

    public DynamicDataSourceConfig(DataSource dataSource, Map<Object, Object> map) {
        setDefaultTargetDataSource(dataSource);
        setTargetDataSources(map);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getCurrentDataSourceName();
    }

    public static String getCurrentDataSourceName() {
        return dataSourceHolder.get();
    }

    public static void setCurrentDataSourceName(String dataSourceName) {
        dataSourceHolder.set(dataSourceName);
    }

    public static void clearCurrentDataSourceName() {
        dataSourceHolder.remove();
    }

}


