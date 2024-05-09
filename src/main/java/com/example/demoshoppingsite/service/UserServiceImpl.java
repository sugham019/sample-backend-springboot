package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.ResponseObj;
import com.example.demoshoppingsite.model.User;
import com.example.demoshoppingsite.model.status.ResponseStatus;
import com.example.demoshoppingsite.model.status.UserStatus;
import com.example.demoshoppingsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;


    @Override
    public ResponseObj<User> createUser(User user) {

        if(repository.existsById(user.getName())){
            return new ResponseObj<User>(UserStatus.USERNAME_EXISTS);
        }

        User user1 = new User(user.getName(), user.getAge(), user.getPassword());
        repository.save(user);
        ResponseObj<User> responseObj = new ResponseObj<>(UserStatus.USER_CREATED);
        responseObj.setObject(user);
        return responseObj;
    }

    @Override
    public ResponseObj<User> login(String username, String password) {
        return null;
    }
}
