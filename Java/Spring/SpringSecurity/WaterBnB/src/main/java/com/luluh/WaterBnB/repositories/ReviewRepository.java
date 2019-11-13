package com.luluh.WaterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luluh.WaterBnB.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	List<Review> findAll();
}

