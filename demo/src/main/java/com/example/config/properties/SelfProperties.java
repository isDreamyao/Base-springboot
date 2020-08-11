package com.example.config.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-08-10 14:33
 * @description
 */
@Slf4j
@Configuration("SelfPropertiesConfiguration")
public class SelfProperties {

    public static final Properties PROPERTIES = new Properties();

    @Bean("selfProperties")
    public Properties properties() {
        Properties properties = new Properties();
        String basePath = "configuration";
        List<String> list = new ArrayList<String>();
        loadProperty(basePath, list);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String var1 = list.get(i);
                InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(var1);

                try {
                    properties.load(resourceAsStream);
                } catch (IOException e) {
                    log.error("读取配置文件 {} 属性异常：{}", var1, e);
                }
            }
        }

        PROPERTIES.putAll(properties);

        return properties;
    }

    private void loadProperty(String path, List<String> fileList) {
        List<String> files = new ArrayList<String>();

        URL url = this.getClass().getClassLoader().getResource(path);
        File baseFile = new File(url.getFile());
        for (File var1 : baseFile.listFiles()) {
            if (var1.isDirectory()) {
                loadProperty(pathDispose(var1), fileList);
            } else {
                files.add(pathDispose(var1));
            }
        }
        fileList.addAll(files);
    }

    private String pathDispose(File file) {
        String fullPath = file.getPath();
        int i = fullPath.lastIndexOf("classes\\") + 8;
        String var3 = fullPath.substring(i).replaceAll("\\\\", "/");
        return var3;
    }

}


