package com.example.mapper;

import com.example.entity.OilStationEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataBaseOperateMapper {

    List<OilStationEntity> selectOilStation(Map<String, Object> params);

}
