package com.example.demoshoppingsite.Controller;

import com.example.demoshoppingsite.model.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping
    public ResponseEntity placeOrder(Order order){
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public void cancelOrder(){

    }
}
