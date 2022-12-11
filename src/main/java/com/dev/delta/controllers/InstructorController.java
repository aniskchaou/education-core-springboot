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
import com.dev.delta.entities.Instructor;
import com.dev.delta.services.InstructorService;
@Controller
public class InstructorController {
	/**
	 * instructorService
	 */
	@Autowired
	private InstructorService instructorService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/instructors")
	public String getCountries(Model model) {
		List<Instructor> countrries = instructorService.getInstructors();
		model.addAttribute("instructors", countrries);
		return "instructor/index";
	}
	
	@RequestMapping("/editinstructor/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Instructor instructor = instructorService.findById(id).get();
		model.addAttribute("instructor", instructor);

		return "instructor/edit";
	}
	
	
	
	@GetMapping("/addinstructor")
	public String addBlogForm(Model model) {
	
		return "instructor/add";
	}

	/**
	 * addInstructor
	 * @param instructor
	 * @param model
	 * @return
	 */
	@PostMapping("/addinstructor")
	public String addInstructor(Instructor instructor, Model model) {
		instructorService.save(instructor);
		return "redirect:/instructors";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/instructor/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Instructor instructor = instructorService.findById(id).get();
		model.addAttribute("instructor", instructor);

		return "instructor/view";
	}

	/**
	 * updateInstructor
	 * @param id
	 * @param instructor
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateinstructor/{id}")
	public String updateInstructor(@PathVariable("id") long id, @Validated Instructor instructor, 
			BindingResult result,
			Model model) {

		instructorService.save(instructor);
		return "redirect:/instructors";
	}

	/**
	 * deleteInstructor
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteinstructor/{id}")
	@Transactional
	public String deleteInstructor(@PathVariable("id") Long id) {
		instructorService.delete(id);
		return "redirect:/instructors";
	}
}
