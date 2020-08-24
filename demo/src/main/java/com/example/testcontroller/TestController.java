package com.example.testcontroller;

import com.example.entity.OilStationEntity;
import com.example.exception.BaseException;
import com.example.mapper.DataBaseOperateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-04-16 15:44
 * @description
 */
@Slf4j
@RestController
@RequestMapping(value = "/testCon")
public class TestController {

    @Autowired
    private DataBaseOperateMapper dataBaseOperateMapper;

    @GetMapping(value = "/testBaseExce")
    public Object testGlobalBaseException(ModelMap modelMap, String str, @ModelAttribute("author") String author) {
        log.info("model property：{}", modelMap.get("author"));
        if ("".equals(str)) {
            throw new BaseException(400, "自定义异常");
        }

        return str;
    }

    @GetMapping(value = "/testDataSource")
    public void test(HttpServletRequest request) {
        Map<String, Object> parmas = new HashMap<>();
        parmas.put("stationName", request.getParameter("stationName"));

        List<OilStationEntity> oilStationEntityList = dataBaseOperateMapper.selectOilStation(parmas);

        System.out.println(oilStationEntityList);

    }

}


