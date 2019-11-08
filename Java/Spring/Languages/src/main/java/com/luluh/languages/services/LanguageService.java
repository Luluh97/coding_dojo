package com.luluh.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.luluh.languages.models.Language;
import com.luluh.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
    // adding the Language repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the Languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a Language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    
    public void updateLanguage(Language l) {
		
    	Optional<Language> optionalLanguage = languageRepository.findById(l.getId());

    	if(optionalLanguage.isPresent()) {
            Language optionalLanguage1 = optionalLanguage.get();
            optionalLanguage1.setName(l.getName());
            optionalLanguage1.setCreator(l.getCreator());
            optionalLanguage1.setcurrentVersion(l.getcurrentVersion());
            languageRepository.save(optionalLanguage1);
        } else {
            System.out.print("null");;
        }
	     
		
	}
    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);;
	}

    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
}