package com.luluh.ProductCategories.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luluh.ProductCategories.models.Category;



@Repository
public interface catoRepo extends CrudRepository<Category, Long> {

}
