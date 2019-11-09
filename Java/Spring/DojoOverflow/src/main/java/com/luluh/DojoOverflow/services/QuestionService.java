package com.luluh.DojoOverflow.services;


import org.springframework.stereotype.Service;

import com.luluh.DojoOverflow.models.Question;
import com.luluh.DojoOverflow.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;



@Service
public class QuestionService {

    // adding the book repository as a dependency
    private final QuestionRepository questionRepository;
    
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    // returns all the 
    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }
    // creates new
    public Question createQuestion(Question b) {
        return questionRepository.save(b);
    }
    //find one 
    public Question getById(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
}
