package com.telusco.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusco.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

}
