package com.example.demo.dto.request;

import java.time.LocalDate;

//data transfer object, dung de nhan data khi update user
public class UserUpdateRequest {

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


}
