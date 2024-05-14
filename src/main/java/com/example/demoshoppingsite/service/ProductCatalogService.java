package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Response;

public interface ProductCatalogService {

    boolean addProduct(String name, int price, int no);
    boolean removeProduct(String name);
    boolean updateStock(String name, int number);
    boolean updatePrice(String name, int price);
    boolean productExists(String name);

}
