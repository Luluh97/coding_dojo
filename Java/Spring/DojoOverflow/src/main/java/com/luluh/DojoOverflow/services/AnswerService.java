package com.luluh.DojoOverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luluh.DojoOverflow.models.Answer;
import com.luluh.DojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
    
    public List<Answer> allAnswers() {
        return (List<Answer>) answerRepository.findAll();
    }
    public Answer creatAnswer(Answer b) {
        return answerRepository.save(b);
    }
    public Optional<Answer> getById(Long id) {
    	return answerRepository.findById(id);
    }
}
