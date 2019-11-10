package com.luluh.Countries.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.luluh.Countries.models.Country;

import java.util.List;

public interface CountryRepo extends CrudRepository<Country, Long>{
 
//	What query would you run to get all the countries that speak Slovene? 
//	Your query should return the name of the country, language,
//	and language percentage. Your query should arrange the result by 
//	language percentage in descending order.
	
	
    
@Query("SELECT countries.name, languages.language, languages.country_code FROM countries JOIN languages on countries.id = language.country_id WHERE language ='Slovene'")
List<Object[]> joinACountriesTalkSlovene();

//What query would you run to display the total number of cities for each country? 
//Your query should return the name of the country and the total number of cities. 
//Your query should arrange the result by the number of cities in descending order

@Query("SELECT countries.name, COUNT(cities.id) AS num_of_cities FROM countries JOIN cities ON countries.id = cities.country_id GROUP BY countries.id ORDER BY num_of_cities DESC")
List<Object[]> findTotalCitiesOfCountry();

//What query would you run to get all the countries 
//with Surface Area below 501 and Population greater than 100,000?
@Query("SELECT name FROM countries WHERE countries.surface_area < 501 AND countries.population > 10")
List<Object[]> joinCountries();




































}