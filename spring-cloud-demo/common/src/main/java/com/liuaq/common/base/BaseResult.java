package com.liuaq.common.base;

import com.liuaq.common.enums.ResultCodeEnum;

public class BaseResult<T> {

    private T data;

    private int code;

    private String message;

    public BaseResult() {
    }

    public BaseResult(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public static BaseResult success(Object data) {
        return new BaseResult<>(data, ResultCodeEnum.SUCCESS.code, ResultCodeEnum.SUCCESS.msg);
    }

    public static BaseResult success() {
        return new BaseResult<>(null, ResultCodeEnum.SUCCESS.code, ResultCodeEnum.SUCCESS.msg);
    }

    public static BaseResult error(int code, String message) {
        return new BaseResult(null, code, message);
    }

    public static BaseResult error() {
        return new BaseResult(null, ResultCodeEnum.ERROR.code, ResultCodeEnum.ERROR.msg);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
