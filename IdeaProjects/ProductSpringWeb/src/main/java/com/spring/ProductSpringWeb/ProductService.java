package com.spring.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// this is dependency injection , where spring boot handles object create,maintenance and destruction
@Component
public class ProductService {

    // since we are just having the referencing to Product db , use
    // auto wired annotation so spring boot will search and give u the object
    @Autowired
    ProductDB db;

    public List<Product> getAllProducts(){

        return db.findAll();
    }

    public Product getProduct(String name) {

        return db.findByName(name);
    }

    public void addProduct(Product p) {
        db.save(p);
    }
}

