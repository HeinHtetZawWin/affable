package com.example.exercise1;

import com.example.exercise1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise1Application implements CommandLineRunner {

    private ProductService productService;

    public Exercise1Application(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Exercise1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productService.createDb();

        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from product");

        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from customer_order");
        JPAUtil.checkData("select * from order_product");

    }
}
