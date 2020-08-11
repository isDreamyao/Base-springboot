package com.example.config.dataSource.multiDataSourceConfig;

import java.lang.annotation.*;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceAnnotation {

    String name() default "";

}
