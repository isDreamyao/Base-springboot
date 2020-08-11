package com.example.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataBaseOperateMapper {

    List<JSONObject> selectOilStation(Map<String, Object> params);

}
