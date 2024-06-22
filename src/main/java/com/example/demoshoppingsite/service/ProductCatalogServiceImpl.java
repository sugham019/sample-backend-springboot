package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.model.Item;
import com.example.demoshoppingsite.model.User;
import com.example.demoshoppingsite.repository.ProductCatalogRepository;
import com.example.demoshoppingsite.exceptions.OutOfStockException;
import com.example.demoshoppingsite.exceptions.PendingOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService{

    private final ProductCatalogRepository productCatalogRepository;

    @Autowired
    public ProductCatalogServiceImpl(ProductCatalogRepository productCatalogRepository){
        this.productCatalogRepository = productCatalogRepository;
    }

    @Override
    public void addProduct(String name, int price, int no, User user) {

        Item item = new Item(name, price, no, user);
        productCatalogRepository.save(item);
    }

    @Override
    public void removeProduct(Long id) throws PendingOrderException, NotFoundException {

        Optional<Item> optionalItem = productCatalogRepository.findById(id);
        if (optionalItem.isEmpty())
            throw new NotFoundException("Could not find product with given Id");

        Item item = optionalItem.get();
        if(item.hasPendingOrders())
            throw new PendingOrderException("Their are still pending orders.");

        productCatalogRepository.delete(item);
    }

    @Override
    public void updateStock(Long id, int num) throws NotFoundException, OutOfStockException {

        Optional<Item> optionalItem = productCatalogRepository.findById(id);
        if(optionalItem.isEmpty())
            throw new NotFoundException("Could not find product with given Id");

        Item item = optionalItem.get();
        int total_stock = item.getTotal() + num;
        if(total_stock < 0)
            throw new OutOfStockException();

        item.setTotal(total_stock);
        productCatalogRepository.save(item);
    }

    @Override
    public void updatePrice(Long id, int price) throws NotFoundException{

        Optional<Item> optionalItem = productCatalogRepository.findById(id);
        if(optionalItem.isEmpty())
            throw new NotFoundException("Could not find product with given Id");

        Item item = optionalItem.get();
        item.setPrice(price);
        productCatalogRepository.save(item);
    }

    @Override
    public Item getProductById(Long id) throws NotFoundException {

        Optional<Item> optionalItem = productCatalogRepository.findById(id);
        if(optionalItem.isEmpty())
            throw new NotFoundException("Could not find product with given Id");

        return optionalItem.get();
    }

    @Override
    public Iterable<Item> getAllProducts() throws NotFoundException{

        if(productCatalogRepository.count() == 0){
            throw new NotFoundException("Their are no products available.");
        }
        return productCatalogRepository.findAll();
    }

}
