package com.luluh.Countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luluh.Countries.repositories.CityRepo;
import com.luluh.Countries.repositories.CountryRepo;
import com.luluh.Countries.repositories.LangRepo;


@Service
public class ApiService {
    private final CountryRepo countryRepo;
    private final CityRepo cityRepo;
    private final LangRepo langRepo;

    public ApiService(CountryRepo countryRepo,CityRepo cityRepo,LangRepo langRepo ) {
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
        this.langRepo = langRepo;
    }
    

    public List<Object[]> allCountriesTalkSlovene() {
        return countryRepo. joinACountriesTalkSlovene();
    }
    
    public List<Object[]> totalCities() {
        return countryRepo.findTotalCitiesOfCountry();
    }
    
    
    public List<Object[]> joinByCountry() {
        return countryRepo.joinCountries();
    }
    
    
    public List<Object[]> getCountryLanguage() {
        return langRepo.getLanguageOfCountry();
    }
    
    
    public List<Object[]> getAllCitites() {
        return cityRepo.findCities();
    }
    
}
