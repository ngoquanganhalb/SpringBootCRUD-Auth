package com.example.demo.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
//data transfer object, dung de nhan data khi update user
public class UserUpdateRequest {
     String password;
     String firstName;
     String laseName;
     LocalDate dob;
}
