package com.example.demoshoppingsite.repository;

import com.example.demoshoppingsite.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ProductCatalogRepository extends CrudRepository<Item, String> {

}
