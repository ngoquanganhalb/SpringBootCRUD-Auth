package com.example.demo.exception;

public enum ErrorCode {
    USER_EXISTED(1002, "User existed"),
    UNCATEGORIZED_EXCEPTION(9999, "AUncategorized exception"),
    PASSWORD_INVALID(1003,"Password must be at least 6 chars "),
    USERNAME_INVALID(1004,"USERNAME must be at least 3 chars "),
    INVALID_KEY(1001,"Invalid message key, kiem tra lai phan dto xem key da dung chua vd: @Size(min=6,message = \"PASSWORD_INVALID\")")
    ;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
