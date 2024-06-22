package com.example.demoshoppingsite.Controller;


import com.example.demoshoppingsite.exceptions.NotFoundException;
import com.example.demoshoppingsite.model.Item;
import com.example.demoshoppingsite.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductCatalogController {

    private final ProductCatalogService productCatalogService;

    @Autowired
    public ProductCatalogController(ProductCatalogService productCatalogService){
        this.productCatalogService = productCatalogService;
    }

    @GetMapping("/product")
    public ResponseEntity<Item> getProductById(@RequestParam Long id) throws NotFoundException {
        Item product = productCatalogService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Iterable<Item>> getProducts() throws NotFoundException {
        Iterable<Item> products = productCatalogService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
