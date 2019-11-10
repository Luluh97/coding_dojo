package com.luluh.Countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.luluh.Countries.models.Language;

public interface LangRepo extends CrudRepository<Language, Long>{

//	What query would you run to get all languages in each country with 
//	a percentage greater than 89%?
//	Your query should arrange the result by percentage in descending order.
	
	@Query("SELECT countries.name, languages.language, languages.percentage FROM countries JOIN languages on countries.id = language.country_id WHERE percentage>89")
	List<Object[]> getLanguageOfCountry();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
