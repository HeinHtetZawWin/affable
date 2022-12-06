package com.example.exercise1.service;

import com.example.exercise1.dao.CategoryDao;
import com.example.exercise1.dao.CustomerDao;
import com.example.exercise1.dao.ProductDao;
import com.example.exercise1.ds.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ProductService {



    private final CategoryDao categoryDao;

    private final CustomerDao customerDao;

    public ProductService(CategoryDao categoryDao, CustomerDao customerDao) {
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
    }

    @Transactional
    public void createDb() {
        Category c1 = new Category();
        c1.setName("Fruits");
        Category c2 = new Category();
        c2.setName("Diary");

        Product p1 = new Product("Apple",2000, "fresh fruit", LocalDate.now());
        Product p2 = new Product("Orange",2000, "fresh fruit", LocalDate.now());
        Product p3 = new Product("Milk",2500, "fresh diary", LocalDate.now());
        Product p4 = new Product("Butter",2500, "fresh diary", LocalDate.now());

        Customer customer1 = new Customer("John Doe", "john@gmail.com","55-5555-55", "Love Lane", "Yangon", "111");
        Customer customer2 = new Customer("Thomas Hardy", "thomas@gmail.com","55-5555-56", "Dream Lane", "Yangon", "222");

        CustomerOrder customerOrder1 = new CustomerOrder(2.5, LocalDate.now(), 12345);
        CustomerOrder customerOrder2 = new CustomerOrder(3, LocalDate.now(), 12345);
        CustomerOrder customerOrder3 = new CustomerOrder(4, LocalDate.now(), 12345);
        CustomerOrder customerOrder4 = new CustomerOrder(2, LocalDate.now(), 12345);

        OrderedProduct orderedProduct1 = new OrderedProduct(30);
        OrderedProduct orderedProduct2 = new OrderedProduct(20);
        OrderedProduct orderedProduct3 = new OrderedProduct(10);
        OrderedProduct orderedProduct4 = new OrderedProduct(5);

        //mapping

        c1.addProduct(p1);
        c1.addProduct(p2);
        c2.addProduct(p3);
        c2.addProduct(p4);

        customer1.addCustomerOrder(customerOrder1);
        customer1.addCustomerOrder(customerOrder2);
        customer2.addCustomerOrder(customerOrder3);
        customer2.addCustomerOrder(customerOrder4);

        customerOrder1.addOrderedProduct(orderedProduct1);
        p1.addOrderedProduct(orderedProduct1);

        customerOrder2.addOrderedProduct(orderedProduct2);
        p2.addOrderedProduct(orderedProduct2);

        customerOrder3.addOrderedProduct(orderedProduct3);
        p3.addOrderedProduct(orderedProduct3);

        customerOrder4.addOrderedProduct(orderedProduct4);
        p4.addOrderedProduct(orderedProduct4);

        categoryDao.save(c1);
        categoryDao.save(c2);

        customerDao.save(customer1);
        customerDao.save(customer2);

    }
}