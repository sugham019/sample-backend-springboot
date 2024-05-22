package com.example.demoshoppingsite.service;

import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.model.Item;
import com.example.demoshoppingsite.repository.ProductCatalogRepository;
import com.example.demoshoppingsite.exceptions.OutOfStockException;
import com.example.demoshoppingsite.exceptions.PendingOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService{

    @Autowired
    private ProductCatalogRepository productCatalogRepository;


    @Override
    public Item addProduct(String name, int price, int no) {

        Item item = new Item(name, price, no);
        productCatalogRepository.save(item);
        return item;
    }

    @Override
    public void removeProduct(Long id) throws PendingOrderException, NotFoundException {

        if(!productCatalogRepository.existsById(id))
            throw new NotFoundException("Could not find product with given Id");

        Item item = productCatalogRepository.findById(id).get();
        if(item.hasPendingOrders())
            throw new PendingOrderException("Their are still pending orders.");

        productCatalogRepository.delete(item);
    }

    @Override
    public void updateStock(Long id, int num) throws NotFoundException, OutOfStockException {

        if(!productCatalogRepository.existsById(id))
            throw new NotFoundException("Could not find product with given Id");

        Item item = productCatalogRepository.findById(id).get();
        int total_stock = item.getTotal() + num;
        if(total_stock < 0)
            throw new OutOfStockException();

        item.setTotal(total_stock);
        productCatalogRepository.save(item);
    }

    @Override
    public void updatePrice(Long id, int price) throws NotFoundException{

        if(!productCatalogRepository.existsById(id))
            throw new NotFoundException("Could not find product with given Id");

        Item item = productCatalogRepository.findById(id).get();
        item.setPrice(price);
        productCatalogRepository.save(item);
    }

    @Override
    public Item getProductById(Long id) throws NotFoundException {

        if(!productCatalogRepository.existsById(id))
            throw new NotFoundException("Could not find product with given Id");

        Item item = productCatalogRepository.findById(id).get();
        return item;
    }

}
