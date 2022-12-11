package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.dev.delta.repositories.QuestionRepository;

public class QuestionDTO implements DTO {

	@Autowired
	QuestionRepository   questionRepository;
	
	@Override
	public void populate() {
		question.setMarks("");
		question.setQuestion("");
		question.setQuestionType("");
		questionRepository.save(question);

	}

}
