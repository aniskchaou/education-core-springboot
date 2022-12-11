package com.dev.delta.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.delta.entities.Category;
import com.dev.delta.entities.Quiz;
import com.dev.delta.services.QuizService;
@Controller
public class QuizController {
	/**
	 * quizService
	 */
	@Autowired
	private QuizService quizService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/quizes")
	public String getCountries(Model model) {
		List<Quiz> countrries = quizService.getQuizs();
		model.addAttribute("quizes", countrries);
		return "quiz/index";
	}
	
	@GetMapping("/addquiz")
	public String addBlogForm(Model model) {
	
		return "quiz/add";
	}
	
	@RequestMapping("/editquiz/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Quiz quiz = quizService.findById(id).get();
		model.addAttribute("quiz", quiz);

		return "quiz/edit";
	}
	
	

	/**
	 * addQuiz
	 * @param quiz
	 * @param model
	 * @return
	 */
	@PostMapping("/addquiz")
	public String addQuiz(Quiz quiz, Model model) {
		quizService.save(quiz);
		return "redirect:/quizes";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/quiz/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Quiz quiz = quizService.findById(id).get();
		model.addAttribute("quiz", quiz);

		return "quiz/view";
	}

	/**
	 * updateQuiz
	 * @param id
	 * @param quiz
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatequiz/{id}")
	public String updateQuiz(@PathVariable("id") long id, @Validated Quiz quiz, 
			BindingResult result,
			Model model) {

		quizService.save(quiz);
		return "redirect:/quizes";
	}

	/**
	 * deleteQuiz
	 * @param id
	 * @return
	 */
	@GetMapping("/deletequiz/{id}")
	@Transactional
	public String deleteQuiz(@PathVariable("id") Long id) {
		quizService.delete(id);
		return "redirect:/quizes";
	}
}
