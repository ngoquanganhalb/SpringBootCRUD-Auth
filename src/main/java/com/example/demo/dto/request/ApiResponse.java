package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

//T đại diện cho một kiểu dữ liệu bất kỳ, sẽ được xác định khi bạn sử dụng class ApiResponse.
@JsonInclude(JsonInclude.Include.NON_NULL) // nhung field NULL(code,message,result) se khong show trong JSON
public class ApiResponse <T> {
    private int code = 1000; //code =1000 = success
    private String message;
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
