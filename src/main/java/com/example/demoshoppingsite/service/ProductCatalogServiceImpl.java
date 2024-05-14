package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.model.Item;
import com.example.demoshoppingsite.model.Response;
import com.example.demoshoppingsite.repository.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService{

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @Override
    public boolean addProduct(String name, int price, int no){
        if(productExists(name)) return false;

        Item item = new Item(name, price, no);
        productCatalogRepository.save(item);
        return true;
    }

    @Override
    public boolean removeProduct(String name) {
        if(!productExists(name)) return false;
        productCatalogRepository.deleteById(name);
        return true;
    }

    @Override
    public boolean updateStock(String name, int number) {
        if(!productExists(name)) return false;

        Item item = productCatalogRepository.findById(name).get();
        item.setTotal(item.getTotal()+number);
        productCatalogRepository.save(item);
        return true;
    }

    @Override
    public boolean updatePrice(String name, int price) {
        if(!productExists(name)) return false;

        Item item = productCatalogRepository.findById(name).get();
        item.setPrice(price);
        productCatalogRepository.save(item);
        return true;
    }

    @Override
    public boolean productExists(String name) {
        return productCatalogRepository.existsById(name);
    }
}
