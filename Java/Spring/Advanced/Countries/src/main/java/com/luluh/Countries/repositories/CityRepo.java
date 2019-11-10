package com.luluh.Countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.luluh.Countries.models.City;


public interface CityRepo extends CrudRepository<City, Long>{

//	What query would you run to get all the cities in Mexico with a population of greater than
//	500,000? 
//	Your query should arrange the result by population in descending order.

	@Query("SELECT cities.name,cities.population FROM cities JOIN countries WHERE country.name ='Mexico' AND cities.population>50000")
	List<Object[]> findCities();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}