package com.example.demo.service;

import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//xử lý logic tạo mới user, chuyển từ DTO sang entity rồi lưu vào database.
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
//            throw new RuntimeException("ErrorCode.USER_EXISTED");

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLaseName(request.getLaseName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public User updateUser(String userId, UserUpdateRequest request){
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLaseName(request.getLaseName());
        user.setDob(request.getDob());
        return userRepository.save(user);

    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll(); //lay tat ca data
    }

    public User getUser(String id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found in service"));
    }

}
