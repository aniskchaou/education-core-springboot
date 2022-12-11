package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Quiz;
import com.dev.delta.repositories.QuizRepository;
@Service
public class QuizService {
	/**
	 * quizRepository
	 */
	@Autowired
	private QuizRepository quizRepository;
	

	/**
	 * getQuizs
	 * @return
	 */
	public java.util.List<Quiz> getQuizs()
	{
		return quizRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return quizRepository.count();
	}

	/**
	 * save
	 * @param quiz
	 */
	public void save(Quiz quiz)
	{
		quizRepository.save(quiz);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Quiz> findById(Long id) {
		return quizRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		quizRepository.delete(quizRepository.findById(id).get());
	}
}
