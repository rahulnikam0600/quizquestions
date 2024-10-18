package com.telusco.quizapp.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telusco.quizapp.model.Question;


@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	@Query(value = "SELECT * FROM quizquestions q WHERE q.category = :category ORDER BY RAND()", nativeQuery = true)
	public List<Question> findRandomQuestionByCategory( @Param("category") String category, Pageable pageable);

}
