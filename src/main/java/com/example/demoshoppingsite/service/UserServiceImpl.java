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
        repository.save(user1);
        ResponseObj<User> responseObj = new ResponseObj<>(UserStatus.USER_CREATED);
        responseObj.setObject(user1);
        return responseObj;
    }

    @Override
    public ResponseObj<User> authenticate(String username, String password) {

        if(!repository.existsById(username)){
            return new ResponseObj<User>(UserStatus.USERNAME_WRONG);
        }

        User user = repository.findById(username).get();
        if(!user.getPassword().equals(password)){
            return new ResponseObj<User>(UserStatus.PASSWORD_WRONG);
        }
        ResponseObj<User> responseObj = new ResponseObj<>(UserStatus.CORRECT_INFORMATION);
        responseObj.setObject(user);
        return responseObj;
    }
}
