package com.telusco.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusco.quizapp.dao.QuestionDao;
import com.telusco.quizapp.dao.QuizDao;
import com.telusco.quizapp.model.Question;
import com.telusco.quizapp.model.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> getQuiz(String category, int noOfQuestions, String title) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, noOfQuestions);
		
		List<Question> questions = questionDao.findRandomQuestionByCategory(category,pageable);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		quizDao.save(quiz);
		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

}
