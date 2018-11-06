package com.me.core.constant.enums;

public enum ResponseCode {
    SUCCESS("SUCCESS", "SUCCESS"),
    SYSTEM_ERROR("SYSTEM_ERROR", "Contact our team"),
    DUPLICATE_DATA("DUPLICATE_DATA", "Duplicate data"),
    DATA_NOT_EXIST("DATA_NOT_EXIST", "No data exist"),
    BIND_ERROR("BIND_ERROR", "Please fill in mandatory parameter"),
    TOKEN_INVALID("TOKEN_INVALID", "Token invalid"),
    LOGIN_ATTEMPT("TO_MANY_LOGIN_ATTEMPT", "To many login attempt!, Your account has been blocked due to suspicious activity."),
    RUNTIME_ERROR("RUNTIME_ERROR", "Runtime Error");

    private String code;
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
