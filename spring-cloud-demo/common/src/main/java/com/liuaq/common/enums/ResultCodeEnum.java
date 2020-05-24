package com.liuaq.common.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "SUCCESS"),
    ERROR(500, "ERROR");

    public int code;

    public String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
