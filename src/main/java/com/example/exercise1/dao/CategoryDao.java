package com.example.exercise1.dao;

import com.example.exercise1.ds.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Integer> {
}
