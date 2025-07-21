package com.vignesh.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {


		 ApplicationContext context =  SpringApplication.run(SpringbootdemoApplication.class, args);

		 // DEPENDENCY INJECTION
		 // spring boot handles entire object creation , destruction .
		// ApplicationContext is the container preconfigured by spring boot for this dependency injection
		ProductService service = context.getBean(ProductService.class);

		List<Product> prods = service.getAllProducts();
		System.out.println(prods);

	}

}
