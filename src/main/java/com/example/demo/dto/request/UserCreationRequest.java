package com.example.demo.dto.request;

import com.example.demo.exception.ErrorCode;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
//data transfer object, dung de nhan data khi tao moi user
public class UserCreationRequest {
    @Size(min=3,message = "USERNAME_INVALID")
    private String username;
//    @Size(min=6,message = "Password must be at least 6 chars")
    @Size(min=6,message = "PASSWORD_INVALID") // key = ErrorCode.PASSWORD_INVALID. Vi phai truyen string
    private String password;
    private String firstName;
    private String laseName;
    private LocalDate dob;

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getLaseName() {
        return laseName;
    }

    public void setLaseName(String laseName) {
        this.laseName = laseName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
