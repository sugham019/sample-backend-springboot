package com.example.demoshoppingsite.repository;

import com.example.demoshoppingsite.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
