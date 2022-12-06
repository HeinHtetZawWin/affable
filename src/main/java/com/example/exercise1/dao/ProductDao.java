package com.example.exercise1.dao;

import com.example.exercise1.ds.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
