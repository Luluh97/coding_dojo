package com.luluh.ProductCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luluh.ProductCategories.models.Product;

@Repository
public interface proRepo extends CrudRepository<Product, Long>{

}

