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
import com.dev.delta.entities.Question;
import com.dev.delta.services.QuestionService;
@Controller
public class QuestionController {
	/**
	 * questionService
	 */
	@Autowired
	private QuestionService questionService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/questions")
	public String getCountries(Model model) {
		List<Question> countrries = questionService.getQuestions();
		model.addAttribute("questions", countrries);
		return "question/index";
	}
	
	@GetMapping("/addquestion")
	public String addBlogForm(Model model) {
	
		return "question/add";
	}
	
	@RequestMapping("/editquestion/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Question question = questionService.findById(id).get();
		model.addAttribute("question", question);

		return "question/edit";
	}

	/**
	 * addQuestion
	 * @param question
	 * @param model
	 * @return
	 */
	@PostMapping("/addquestion")
	public String addQuestion(Question question, Model model) {
		questionService.save(question);
		return "redirect:/questions";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/question/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Question question = questionService.findById(id).get();
		model.addAttribute("question", question);

		return "question/view";
	}

	/**
	 * updateQuestion
	 * @param id
	 * @param question
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatequestion/{id}")
	public String updateQuestion(@PathVariable("id") long id, @Validated Question question, 
			BindingResult result,
			Model model) {

		questionService.save(question);
		return "redirect:/questions";
	}

	/**
	 * deleteQuestion
	 * @param id
	 * @return
	 */
	@GetMapping("/deletequestion/{id}")
	@Transactional
	public String deleteQuestion(@PathVariable("id") Long id) {
		questionService.delete(id);
		return "redirect:/questions";
	}
}
