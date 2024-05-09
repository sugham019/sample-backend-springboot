package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.ResponseObj;
import com.example.demoshoppingsite.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseObj<User> createUser(User user);
    ResponseObj<User> authenticate(String username, String password);
}
