package com.example.globalSetting;

import com.alibaba.fastjson.JSONObject;
import com.example.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-04-16 10:22
 * @description 全局异常捕获 针对RequestMapping注解的方法
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionCapture {

    /**
     * 所有异常处理
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject exception(Exception e) {
        log.error("Exception: {}", e);

        JSONObject res = new JSONObject();
        res.put("message", e.getMessage());
        res.put("cause", e.getCause());
        return res;
    }

    /**
     * 基础异常处理
     *
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public JSONObject baseException(BaseException e) {
        log.error("Exception: {}", e);

        JSONObject res = new JSONObject();
        res.put("message", e.getMessage());
        res.put("cause", e.getCause());
        return res;
    }

}


