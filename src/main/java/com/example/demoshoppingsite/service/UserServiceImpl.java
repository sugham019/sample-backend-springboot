package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.User;
import org.springframework.http.ResponseEntity;

public class UserServiceImpl implements UserService{

    @Override
    public ResponseEntity<User> createUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> login(String username, String password) {
        return null;
    }
}
