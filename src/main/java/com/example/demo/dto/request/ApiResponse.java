package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

//T đại diện cho một kiểu dữ liệu bất kỳ, sẽ được xác định khi bạn sử dụng class ApiResponse.
@JsonInclude(JsonInclude.Include.NON_NULL) // nhung field NULL(code,message,result) se khong show trong JSON
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse <T> {
     int code = 1000; //code =1000 = success
     String message;
     T result;
}
