package com.example.testcontroller;

import com.example.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-04-16 15:44
 * @description
 */
@Slf4j
@RestController
@RequestMapping(value = "testCon")
public class TestController {

    @GetMapping(value = "testBaseExce")
    public Object testGlobalBaseException(ModelMap modelMap, String str, @ModelAttribute("author") String author) {
        log.info("model property：{}", modelMap.get("author"));
        if ("".equals(str)) {
            throw new BaseException(400, "自定义异常");
        }

        return str;
    }


}


