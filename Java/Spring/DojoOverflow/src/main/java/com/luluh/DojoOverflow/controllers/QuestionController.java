package com.luluh.DojoOverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luluh.DojoOverflow.models.Answer;
import com.luluh.DojoOverflow.models.Question;
import com.luluh.DojoOverflow.models.Tag;
import com.luluh.DojoOverflow.services.AnswerService;
import com.luluh.DojoOverflow.services.QuestionService;
import com.luluh.DojoOverflow.services.TagService;




@Controller
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
    public QuestionController(QuestionService questionService,TagService tagService,AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }
  
    @RequestMapping("/questions")
    public String index(Model model) {
        List<Question> questions = questionService.allQuestions();
        model.addAttribute("questions", questions);
        return "/dashboard.jsp";
    }
    
    @RequestMapping("/questions/new")
    public String newQuestion(@ModelAttribute("question") Question question) {
        return "questions.jsp";
    }
    
    @RequestMapping(value="/questions/new", method=RequestMethod.POST)
    public String create(@RequestParam("question") String question, @RequestParam("tag") String tagStr) {
        if (question.equals("")) {
            return "redirect:/questions.jsp";
        } 
        
        Question newQ = new Question(question);
        
        
        String[] tagList = tagStr.split(",");
        if(tagStr.length()>0) {
        	List<Tag> tags = new ArrayList<>();
        	for (String tag : tagList){
                Tag tag1;
                if(tagService.findBySubject(tag) == null){
                    tag1 = new Tag(tag);
                    tagService.createTag(tag1);
                    Long t_id  = tag1.getId();
                    tag1 = tagService.getById(t_id);
                }else{
                    tag1 = tagService.findBySubject(tag);
                }
                tags.add(tag1);
            }
        	newQ.setTag(tags);
        	
        }
        questionService.createQuestion(newQ);
        return "redirect:/questions";
    }
    
    @RequestMapping("/questions/{id}")
    public String show(@PathVariable("id") Long id, @ModelAttribute("answer1") Answer ans, Model model) {
        Question question = questionService.getById(id);
        model.addAttribute("question", question);

        
        return "/show.jsp";
    }
    
    @RequestMapping(value="/questions/{id}", method=RequestMethod.POST)
    public String answer(@Valid @ModelAttribute("answer1") Answer ans, Model model, BindingResult result, @PathVariable("id") Long id) {

    	Question q = questionService.getById(id);
        if (result.hasErrors()) {
            return "redirect:/questions/{id}";
        } else {
        	ans.setQuestion(q);
        	answerService.creatAnswer(ans);
        	return "redirect:/questions/"+id;
        }
    }
    
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
