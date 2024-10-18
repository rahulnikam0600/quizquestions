package com.telusco.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusco.quizapp.model.Quiz;
import com.telusco.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;

	@PostMapping("create")
	public ResponseEntity<String> quiz(@RequestParam String category, int noOfQuestions, String title) {
		String s = ""+category+"  "+noOfQuestions+"  "+title;
		return quizService.getQuiz(category , noOfQuestions,title);
	}
}
