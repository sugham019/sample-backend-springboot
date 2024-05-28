package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.AuthenticationException;
import com.example.demoshoppingsite.model.*;
import com.example.demoshoppingsite.repository.OrderRepository;
import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.exceptions.OutOfStockException;
import com.example.demoshoppingsite.repository.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{


    private final OrderRepository orderRepository;
    private final ProductCatalogService productCatalogService;
    private final UserService userService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductCatalogService productCatalogService, UserService userService){
        this.orderRepository = orderRepository;
        this.productCatalogService = productCatalogService;
        this.userService = userService;
    }

    @Override
    public void placeOrder(OrderInfo orderInfo) throws OutOfStockException, NotFoundException, AuthenticationException {

        Item product = productCatalogService.getProductById(orderInfo.productId());
        User user = userService.authenticate(orderInfo.userId(), orderInfo.password());

        if(product.getTotal() < orderInfo.total()){
            throw new OutOfStockException("Out Of Stock");
        }
        Date currentDate = new Date();
        Order order = new Order(user, product, currentDate, orderInfo.total());
        productCatalogService.updateStock(product.getId(), -order.getTotal());
        orderRepository.save(order);
    }

    @Override
    public void completeOrder(Long orderId) throws NotFoundException{

        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if(orderOptional.isEmpty()){
            throw new NotFoundException("Their are no active orders with given Id");
        }
        Order order = orderOptional.get();
        orderRepository.delete(order);
    }

    @Override
    public void cancelOrder(User user, Order order) {

    }

    @Override
    public Order[] getOrders(User user) {
        return new Order[0];
    }


}
