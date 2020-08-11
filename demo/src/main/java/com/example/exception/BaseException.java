package com.example.exception;

import lombok.Data;

/**
 * @author HuangHaiLong
 * @version 1.0
 * @date 2020-04-16 10:29
 * @description
 */
@Data
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }
}


