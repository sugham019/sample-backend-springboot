package com.example.demoshoppingsite;

import com.example.demoshoppingsite.model.Response;
import com.example.demoshoppingsite.model.ResponseObj;
import com.example.demoshoppingsite.model.User;
import com.example.demoshoppingsite.model.status.UserStatus;
import com.example.demoshoppingsite.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void createUser(){
        User user = new User("test123", 18, "test123");
        ResponseObj<User> responseObj = userService.createUser(user);
        assertEquals(UserStatus.USER_CREATED.getStatus(), responseObj.getResponseStatus().getStatus());
//        assertEquals(responseObj.getResponseStatus().getStatus(), UserStatus.USERNAME_EXISTS.getStatus());
    }

    @Test
    public void authenticate(){
        ResponseObj<User> responseObj = userService.authenticate("test123", "test1234");
        assertEquals(UserStatus.CORRECT_INFORMATION.getStatus(), responseObj.getResponseStatus().getStatus());
//        assertEquals(UserStatus.PASSWORD_WRONG.getStatus(), responseObj.getResponseStatus().getStatus());
//        assertEquals(UserStatus.USERNAME_WRONG.getStatus(), responseObj.getResponseStatus().getStatus());
    }
}
