package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.User;
import com.example.demoshoppingsite.exceptions.AuthenticationException;
import com.example.demoshoppingsite.exceptions.DuplicateException;
import com.example.demoshoppingsite.exceptions.PendingOrderException;

public interface UserService {

    void createUser(User user) throws DuplicateException;
    User authenticate(String username, String password) throws AuthenticationException;
    void changePassword(String username, String oldPassword, String newPassword) throws AuthenticationException;
    void deleteAccount(String username, String password) throws AuthenticationException, PendingOrderException;
}
