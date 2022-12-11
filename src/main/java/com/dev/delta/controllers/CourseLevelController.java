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
import com.dev.delta.entities.CourseLevel;
import com.dev.delta.services.CourseLevelService;
@Controller
public class CourseLevelController {
	/**
	 * courseLevelService
	 */
	@Autowired
	private CourseLevelService courseLevelService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/courselevels")
	public String getCountries(Model model) {
		List<CourseLevel> countrries = courseLevelService.getCourseLevels();
		model.addAttribute("courseLevels", countrries);
		return "courseLevel/index";
	}
	
	@RequestMapping("/editcourselevel/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		CourseLevel courseLevel = courseLevelService.findById(id).get();
		model.addAttribute("courseLevel", courseLevel);

		return "courselevel/edit";
	}
	
	
	@GetMapping("/addcourselevel")
	public String addBlogForm(Model model) {
	
		return "courselevel/add";
	}

	/**
	 * addCourseLevel
	 * @param courseLevel
	 * @param model
	 * @return
	 */
	@PostMapping("/addcourselevel")
	public String addCourseLevel(CourseLevel courseLevel, Model model) {
		courseLevelService.save(courseLevel);
		return "redirect:/courselevels";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/courselevel/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		CourseLevel courseLevel = courseLevelService.findById(id).get();
		model.addAttribute("courseLevel", courseLevel);

		return "courselevel/view";
	}

	/**
	 * updateCourseLevel
	 * @param id
	 * @param courseLevel
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatecourselevel/{id}")
	public String updateCourseLevel(@PathVariable("id") long id, @Validated CourseLevel courseLevel, 
			BindingResult result,
			Model model) {

		courseLevelService.save(courseLevel);
		return "redirect:/courselevels";
	}

	/**
	 * deleteCourseLevel
	 * @param id
	 * @return
	 */
	@GetMapping("/deletecourselevel/{id}")
	@Transactional
	public String deleteCourseLevel(@PathVariable("id") Long id) {
		courseLevelService.delete(id);
		return "redirect:/courselevels";
	}
}
