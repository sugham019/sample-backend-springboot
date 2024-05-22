package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.User;
import com.example.demoshoppingsite.repository.UserRepository;
import com.example.demoshoppingsite.exceptions.AuthenticationException;
import com.example.demoshoppingsite.exceptions.DuplicateException;
import com.example.demoshoppingsite.exceptions.PendingOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUser(User user) throws DuplicateException {

        user.clearOrders();
        if(userRepository.existsById(user.getName())){
            throw new DuplicateException("User already Exists with the given id");
        }
        userRepository.save(user);
    }


    @Override
    public User authenticate(String username, String password) throws AuthenticationException {

        if(!userRepository.existsById(username)){
            throw new AuthenticationException("Could not find user with given Id");
        }

        User user = userRepository.findById(username).get();
        if(!user.getPassword().equals(password)){
            throw new AuthenticationException("Incorrect password");
        }
        return user;
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) throws AuthenticationException{

        if(!userRepository.existsById(username)){
            throw new AuthenticationException("Incorrect Id");
        }
        User user = userRepository.findById(username).get();
        if(!user.getPassword().equals(oldPassword)){
            throw new AuthenticationException("Incorrect password");
        }
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    @Override
    public void deleteAccount(String username, String password) throws AuthenticationException, PendingOrderException {

        if(!userRepository.existsById(username)){
            throw new AuthenticationException("User does not exists");
        }
        User user = userRepository.findById(username).get();
        if(!user.getPassword().equals(password)){
            throw new AuthenticationException("Incorrect password");
        }
        userRepository.deleteById(username);
    }
}
