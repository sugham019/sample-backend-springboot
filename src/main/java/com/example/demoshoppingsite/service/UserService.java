package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Response;
import com.example.demoshoppingsite.model.ResponseObj;
import com.example.demoshoppingsite.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseObj<User> createUser(User user);
    ResponseObj<User> authenticate(String username, String password);
    Response changePassword(String username, String oldPassword, String newPassword);
    Response deleteAccount(String username, String password);

}
