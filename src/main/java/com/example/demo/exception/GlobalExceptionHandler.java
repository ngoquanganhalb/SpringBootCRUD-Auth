package com.example.demo.exception;

import com.example.demo.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //áp dụng để xử lý ngoại lệ cho toàn bộ controller trong ứng dụng.
public class GlobalExceptionHandler {
    //voi exception runtime
//    @ExceptionHandler(value = RuntimeException.class) //tat ca RuntimeException se vao day
//    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception){
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(1001);
//        apiResponse.setMessage(exception.getMessage());
//        return ResponseEntity.badRequest().body(apiResponse); //badReq =400
//    }

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    ResponseEntity<String> handleValidation(MethodArgumentNotValidException exception){
//        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
//    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handleValidation(MethodArgumentNotValidException exception){
        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e) {
        }

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    //AppException (customed exception)
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception){
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse); //badReq =400
    }

    //voi exception con lai
    @ExceptionHandler(value = Exception.class) //tat ca RuntimeException se vao day
    ResponseEntity<ApiResponse> handlingException(Exception exception){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiResponse); //badReq =400
    }


}
