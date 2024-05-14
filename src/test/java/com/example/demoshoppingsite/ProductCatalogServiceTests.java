package com.example.demoshoppingsite;

import com.example.demoshoppingsite.repository.ProductCatalogRepository;
import com.example.demoshoppingsite.service.ProductCatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductCatalogServiceTests {

    @Autowired
    private ProductCatalogService productCatalogService;


    @Test
    public void addProduct(){
        assertEquals(true, productCatalogService.addProduct("Laptop", 20000, 5));
    }

    @Test
    public void updateStock(){
        assertEquals(true, productCatalogService.updateStock("Laptop", -2));
    }

    @Test
    public void updatePrice(){
        assertEquals(true, productCatalogService.updatePrice("Laptop", 500));
    }


    @Test
    public void removeProduct(){
        assertEquals(true, productCatalogService.removeProduct("Laptop"));
    }


}
