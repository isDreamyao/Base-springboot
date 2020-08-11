package com.example.globalSetting;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-04-16 10:53
 * @description 全局属性设置 针对RequestMapping注解的方法
 */
@ControllerAdvice
public class GlobalModelProperty {


    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * (@ModelAttribute("author") String author) 获取 或者
     * ModelMap 方式获取  形参
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "hhl11");
    }


}


