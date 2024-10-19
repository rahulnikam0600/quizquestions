package com.telusco.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusco.quizapp.dao.QuestionDao;
import com.telusco.quizapp.dao.QuizDao;
import com.telusco.quizapp.model.Question;
import com.telusco.quizapp.model.QuestionWrapper;
import com.telusco.quizapp.model.Quiz;
import com.telusco.quizapp.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(0, noOfQuestions);
		
		List<Question> questions = questionDao.findRandomQuestionByCategory(category,pageable);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		quizDao.save(quiz);
		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		
		Quiz quiz = quizDao.findById(id).get();
		
		List<Question> questionsFromDbList = quiz.getQuestions();
		
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		
		for(Question q: questionsFromDbList) {
			
			QuestionWrapper qWrapper = QuestionWrapper.builder()
					.id(q.getId())
					.question(q.getQuestion())
					.option1(q.getOption1())
					.option2(q.getOption2())
					.option3(q.getOption3())
					.option4(q.getOption4())
					.build();
			questionsForUser.add(qWrapper);
		}
		
		return new ResponseEntity<List<QuestionWrapper>>(questionsForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> quizResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		
		Integer score = 0;
		
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDbList = quiz.get().getQuestions();
		System.out.println(questionsFromDbList);
		int i = 0;
		for(Response res: responses) {
			
			if(res.getResponse().equals(questionsFromDbList.get(i).getCorrectAnswer())) {
				score++;
			}
			i++;
		}
		
		return new ResponseEntity<Integer>(score,HttpStatus.OK);
	}

}
