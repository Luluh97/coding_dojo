package com.luluh.DriverLicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luluh.DriverLicense.models.Person;
import com.luluh.DriverLicense.repositories.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person createPerson(Person b) {
        return personRepository.save(b);
    }
    public List<Person> allPersons() {
        return personRepository.findAll();
    }

}