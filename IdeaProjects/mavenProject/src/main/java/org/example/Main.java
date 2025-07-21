package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        service.addProduct(new Product("Asus Vivobook","Laptop","Brown table",2022));
        service.addProduct(new Product("Dell","Laptop","Black table",2023));
        service.addProduct(new Product("Sony","Mobile","Drawer",2022));

//        List<Product> prods = service.getProductWithText("mobile");

//        for(Product p:prods){
//            System.out.println("matched" + p);
//        }
        List<Product> prods = service.getAllProducts();
        System.out.println(prods);

    }
}