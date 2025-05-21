package com.example.demo.service;

import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//xử lý logic tạo mới user, chuyển từ DTO sang entity rồi lưu vào database.
@Service
@RequiredArgsConstructor //sinh ra constructor vs ca final
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserService {

     UserRepository userRepository;
     UserMapper userMapper; //map data tu Mapper

    public User createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        return userRepository.save(user);
    }
    public UserResponse updateUser(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found in service"));;
        userMapper.updateUser(user,request);
        return userMapper.toUserResponse(userRepository.save(user));
    }
//    public User createUser(UserCreationRequest request){
//        if(userRepository.existsByUsername(request.getUsername()))
//            throw new AppException(ErrorCode.USER_EXISTED);
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLaseName(request.getLaseName());
//        user.setDob(request.getDob());
//
//        return userRepository.save(user);
//    }

//    public User updateUser(String userId, UserUpdateRequest request){
//        User user = getUser(userId);
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLaseName(request.getLaseName());
//        user.setDob(request.getDob());
//        return userRepository.save(user);
//
//    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll(); //lay tat ca data
    }

    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found in service")));

    }

}
