package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Question;
import com.dev.delta.repositories.QuestionRepository;
@Service
public class QuestionService {
	/**
	 * questionRepository
	 */
	@Autowired
	private QuestionRepository questionRepository;
	

	/**
	 * getQuestions
	 * @return
	 */
	public java.util.List<Question> getQuestions()
	{
		return questionRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return questionRepository.count();
	}

	/**
	 * save
	 * @param question
	 */
	public void save(Question question)
	{
		questionRepository.save(question);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Question> findById(Long id) {
		return questionRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		questionRepository.delete(questionRepository.findById(id).get());
	}
}
