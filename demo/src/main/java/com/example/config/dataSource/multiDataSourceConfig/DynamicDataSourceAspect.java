package com.example.config.dataSource.multiDataSourceConfig;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-07-22 10:12
 * @description
 */

@Slf4j
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.example.config.dataSource.multiDataSourceConfig.DataSourceAnnotation)")
    public void cutDataSourcePointCut() {

    }

    @Around("cutDataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSourceAnnotation adAnno = method.getAnnotation(DataSourceAnnotation.class);
        if (adAnno == null) {
            DynamicDataSourceConfig.setCurrentDataSourceName(DataSourceNames.write);
            log.error("******************  dynamic  datasource  switchover : write  ******************");
        } else {
            DynamicDataSourceConfig.setCurrentDataSourceName(adAnno.name());
            log.error("******************  dynamic  datasource  switchover : {}  ******************", adAnno.name());
        }

        long beginTime = System.currentTimeMillis();

        Object result = null;
        try {
            result = point.proceed();
        } finally {
            DynamicDataSourceConfig.clearCurrentDataSourceName();
            log.error("******************  clean datasource  ******************");
        }

        long time = System.currentTimeMillis() - beginTime;

        // 请求类名
        String clzName = point.getTarget().getClass().getName();

        String methodName = point.getSignature().getName();

        log.info("Class: {}  Method: {}  执行时长: {} ms  Result: {}", clzName, methodName, time, result);

        return result;
    }


}


