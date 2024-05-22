package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Item;
import com.example.demoshoppingsite.exceptions.OutOfStockException;
import com.example.demoshoppingsite.exceptions.PendingOrderException;

public interface ProductCatalogService {

    Item addProduct(String name, int price, int no);
    void removeProduct(Long id) throws PendingOrderException, NotAvailableException;
    void updateStock(Long id, int num) throws NotAvailableException, OutOfStockException;
    void updatePrice(Long id, int price) throws NotAvailableException;
    Item getProductById(Long id) throws NotAvailableException;

}
