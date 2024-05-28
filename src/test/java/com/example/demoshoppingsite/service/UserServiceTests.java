package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.DuplicateException;
import com.example.demoshoppingsite.model.Item;
import com.example.demoshoppingsite.model.User;
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

        List<Item> list = new ArrayList<>();

        list.forEach(n ->
        {

        });
        User user = new User("Test123", 18, "Test123");
        userService.createUser(user);
    }
}
