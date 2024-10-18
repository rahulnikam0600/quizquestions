package com.telusco.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusco.quizapp.model.Question;
import com.telusco.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("all_questions")
	public List<Question> getAllQuestion() {
		return questionService.getAllQuestions();
	}
	
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
}
