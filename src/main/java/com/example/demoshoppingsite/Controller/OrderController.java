package com.example.demoshoppingsite.Controller;

import com.example.demoshoppingsite.model.Order;
import com.example.demoshoppingsite.model.Response;
import com.example.demoshoppingsite.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/purchase")
    public Response placeOrder(Order order){
        return orderService.placeOrder(order);
    }

    @DeleteMapping("/cancelOrder")
    public Response cancelOrder(Order order){
        return orderService.cancelOrder(order);
    }
}
