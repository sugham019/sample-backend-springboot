package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.model.Item;
import com.example.demoshoppingsite.exceptions.OutOfStockException;
import com.example.demoshoppingsite.exceptions.PendingOrderException;
import com.example.demoshoppingsite.model.User;

public interface ProductCatalogService {

    void addProduct(String name, int price, int no, User user);
    void removeProduct(Long id) throws PendingOrderException, NotFoundException;
    void updateStock(Long id, int num) throws NotFoundException, OutOfStockException;
    void updatePrice(Long id, int price) throws NotFoundException;
    Item getProductById(Long id) throws NotFoundException;
    Iterable<Item> getAllProducts() throws NotFoundException;

}
