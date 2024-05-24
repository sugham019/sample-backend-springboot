package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.AuthenticationException;
import com.example.demoshoppingsite.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductCatalogService productCatalogService;

    @Autowired
    private UserService userService;


    @Test
    public void addProduct() throws AuthenticationException {
        User user = userService.authenticate("Test123", "Test123");

        productCatalogService.addProduct("Test Laptop", 10000, 20, user);
        assertTrue(true);
    }
}
