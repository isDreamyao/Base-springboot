package com.example.Beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

import java.sql.Date;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-06-30 16:34
 * @description
 */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiveData {

    private Long id;
    private String name;
    private String description;
    private String remark;
    private Date time;

}


