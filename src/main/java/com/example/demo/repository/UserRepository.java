//Đây là interface để thao tác với database cho entity User.
package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaReoisutory cung cap san cac phuong thuc CRUD,String la Kieu khao chinh ID
//giao tiếp với database, dùng để lưu, sửa, xóa, tìm kiếm User.
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUsername(String username);
}
