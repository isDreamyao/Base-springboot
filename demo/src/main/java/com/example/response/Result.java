package com.example.response;

import lombok.Data;

import java.util.Date;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-08-25 9:30
 * @description
 */
@Data
public class Result<T> {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private int errorCode;

    private String sysCode;

    private String errorMsg;

    private T model;

    private Date successTime;

    public Result() {

    }

    public static <T> Result<T> createSuccessRes(T model) {
        Result<T> result = new Result<T>(true);
        result.setModel(model);
        return result;
    }

    public static <T> Result<T> createSuccessRes(T model, Date successTime) {
        Result<T> result = new Result<T>(true);
        result.setModel(model);
        result.setSuccessTime(successTime);
        return result;
    }

    public static <T> Result<T> createFailedRes(int errorCode, String errorMsg) {
        Result<T> result = new Result<T>(false);
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result(boolean success) {
        this.success = success;
    }

}