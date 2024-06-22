package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.DuplicateException;
import com.example.demoshoppingsite.model.Item;
import com.example.demoshoppingsite.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;


    @Test
    public void createUser() throws DuplicateException {

        User user = new User("Test123", 18, "Test123");
        userService.createUser(user);
    }

    @Test
    public void sample() throws JsonProcessingException {
        User user = new User("Test12345", 100, "Test12345");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
    }


}
