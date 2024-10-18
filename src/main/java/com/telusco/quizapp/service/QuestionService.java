package com.telusco.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusco.quizapp.dao.QuestionDao;
import com.telusco.quizapp.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}
}
