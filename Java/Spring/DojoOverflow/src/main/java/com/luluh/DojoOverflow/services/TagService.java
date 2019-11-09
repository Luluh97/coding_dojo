package com.luluh.DojoOverflow.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luluh.DojoOverflow.models.Tag;
import com.luluh.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {

	private final TagRepository tagRepository;
    
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    public Iterable<Tag> allTags() {
        return tagRepository.findAll();
    }
    public Tag createTag(Tag b) {
        return tagRepository.save(b);
    }

    public Tag findBySubject(String subject) {
    	return tagRepository.findBySubjectEquals(subject);
    }
    
    public Tag getById(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
}
