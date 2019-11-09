package com.luluh.DriverLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luluh.DriverLicense.models.License;
import com.luluh.DriverLicense.repositories.LicenseRepository;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;
    

    
    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }
    public void createLicense(License b) {
       licenseRepository.save(b);
       b.setNumber("0000"+b.getId());
       licenseRepository.save(b);
    }
    
    public List<License> all() {
        return licenseRepository.findAll();
    }
    
    
  
    public License LicenseforPerson(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }

}