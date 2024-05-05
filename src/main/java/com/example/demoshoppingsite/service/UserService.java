package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<User> createUser(User user);
    ResponseEntity<User> login(String username, String password);
}
