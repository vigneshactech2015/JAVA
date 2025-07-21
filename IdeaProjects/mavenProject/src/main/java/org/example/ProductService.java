package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();
    ProductDB db = new ProductDB();
    public void addProduct(Product p){
        db.save(p);
    }

    public List<Product> getAllProducts(){

        return db.getAll();
    }

    public Product getProduct(String name){
        for(Product p:products){

            if(p.getName().equals(name.toLowerCase())) {
                return p;
            }
        }
        return null;
    }

    public List<Product> getProductWithText(String text) {
        List<Product> prods = new ArrayList<>();

        for(Product p:products){

            if(p.getName().toLowerCase().contains(text.toLowerCase()) || p.getType().toLowerCase().contains(text.toLowerCase()) || p.getPlace().toLowerCase().contains(text.toLowerCase())) {
                prods.add(p);
            }
        }

        return prods;
    }
}

