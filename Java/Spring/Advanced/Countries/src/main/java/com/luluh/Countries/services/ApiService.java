package com.luluh.Countries.services;

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
}
