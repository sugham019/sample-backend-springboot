package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Response;
import com.example.demoshoppingsite.model.ResponseObj;
import com.example.demoshoppingsite.model.User;
import com.example.demoshoppingsite.model.status.ResponseStatus;
import com.example.demoshoppingsite.model.status.UserStatus;
import com.example.demoshoppingsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public ResponseObj<User> createUser(User user) {

        if(userRepository.existsById(user.getName())){
            return new ResponseObj<User>(UserStatus.USER_EXISTS);
        }

        User user1 = new User(user.getName(), user.getAge(), user.getPassword());
        userRepository.save(user1);
        ResponseObj<User> responseObj = new ResponseObj<>(UserStatus.USER_CREATED);
        responseObj.setObject(user1);
        return responseObj;
    }


    @Override
    public ResponseObj<User> authenticate(String username, String password) {

        if(!userRepository.existsById(username)){
            return new ResponseObj<User>(UserStatus.USERNAME_WRONG);
        }

        User user = userRepository.findById(username).get();
        if(!user.getPassword().equals(password)){
            return new ResponseObj<User>(UserStatus.PASSWORD_WRONG);
        }
        ResponseObj<User> responseObj = new ResponseObj<>(UserStatus.CORRECT_INFORMATION);
        responseObj.setObject(user);
        return responseObj;
    }

    @Override
    public Response changePassword(String username, String oldPassword, String newPassword) {

        if(!userRepository.existsById(username)){
            return new Response(UserStatus.USER_DOESNT_EXIST);
        }
        User user = userRepository.findById(username).get();
        if(!user.getPassword().equals(oldPassword)){
            return new Response(UserStatus.PASSWORD_WRONG);
        }
        user.setPassword(newPassword);
        userRepository.save(user);
        return new Response(UserStatus.PASSWORD_UPDATED);
    }

    @Override
    public Response deleteAccount(String username, String password) {

        if(!userRepository.existsById(username)){
            return new Response(UserStatus.USER_DOESNT_EXIST);
        }
        User user = userRepository.findById(username).get();
        if(!user.getPassword().equals(password)){
            return new Response(UserStatus.PASSWORD_WRONG);
        }
        userRepository.deleteById(username);
        return new Response(UserStatus.ACCOUNT_DELETED);
    }


}
