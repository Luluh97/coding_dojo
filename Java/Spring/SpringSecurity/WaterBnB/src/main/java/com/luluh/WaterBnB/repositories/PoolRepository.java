package com.luluh.WaterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.luluh.WaterBnB.models.Pool;

@Repository
public interface PoolRepository extends CrudRepository<Pool, Long> {
	List<Pool> findAll();
}
