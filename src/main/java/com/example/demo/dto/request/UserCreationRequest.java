package com.example.demo.dto.request;

import com.example.demo.exception.ErrorCode;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
//data transfer object, dung de nhan data khi tao moi user
public class UserCreationRequest {
    @Size(min=3,message = "USERNAME_INVALID")
     String username;
//    @Size(min=6,message = "Password must be at least 6 chars")
    @Size(min=6,message = "PASSWORD_INVALID") // key = ErrorCode.PASSWORD_INVALID. Vi phai truyen string
     String password;
     String firstName;
     String laseName;
     LocalDate dob;


}
