package com.example.config.properties;

import com.example.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Description;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-08-06 16:45
 * @description 这个类需要放到spring 启动配置类才能使用  所以暂时不考虑
 */
@Slf4j
@Deprecated
public class ExtendEnvironmentProperties implements EnvironmentPostProcessor, Ordered {

    public static Properties properties = new Properties();

    private final YamlPropertySourceLoader propertySourceLoader = new YamlPropertySourceLoader();

    @Autowired
    ConfigurableEnvironment environment;

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        String[] propertiesAr = new String[]{
                "dev.properties",
                "play.properties",
                "self.properties"
        };

        for (String path : propertiesAr) {
            Resource resource = new ClassPathResource(path);
            environment.getPropertySources().addLast(loadYaml(resource));
        }
    }

    private PropertySource loadYaml(Resource path) {
        try {

            if (!path.exists()) {
                log.error("资源 {} 不存在", path);
                throw new BaseException(path + "资源不存在");
            }

            properties.load(path.getInputStream());

            return new PropertiesPropertySource(path.getFilename(), properties);
        } catch (IOException e) {
            log.error("加载配置文件异常：{}", e);
            throw new BaseException(path + "加载配置文件异常");

        } finally {
            properties.clear();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }

}


