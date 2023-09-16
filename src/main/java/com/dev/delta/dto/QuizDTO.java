package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.delta.repositories.QuizRepository;

public class QuizDTO implements DTO {

	@Autowired
	QuizRepository  quizRepository ;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
       quiz.setCategory("");
       quiz.setInstruction("");
       quiz.setMinimumPercentage("");
       quiz.setQuizTitle("");
       
       quizRepository.save(quiz);
	}

}
