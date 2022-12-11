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
import com.dev.delta.entities.Course;
import com.dev.delta.services.CourseService;
@Controller
public class CourseController {
	/**
	 * courseService
	 */
	@Autowired
	private CourseService courseService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/courses")
	public String getCountries(Model model) {
		List<Course> countrries = courseService.getCourses();
		model.addAttribute("courses", countrries);
		return "course/index";
	}
	
	@GetMapping("/addcourse")
	public String addBlogForm(Model model) {
	
		return "course/add";
	}
	
	@RequestMapping("/editcourse/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Course course = courseService.findById(id).get();
		model.addAttribute("course", course);

		return "course/edit";
	}

	/**
	 * addCourse
	 * @param course
	 * @param model
	 * @return
	 */
	@PostMapping("/addcourse")
	public String addCourse(Course course, Model model) {
		courseService.save(course);
		return "redirect:/courses";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/course/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Course course = courseService.findById(id).get();
		model.addAttribute("course", course);

		return "course/view";
	}

	/**
	 * updateCourse
	 * @param id
	 * @param course
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatecourse/{id}")
	public String updateCourse(@PathVariable("id") long id, @Validated Course course, 
			BindingResult result,
			Model model) {

		courseService.save(course);
		return "redirect:/courses";
	}

	/**
	 * deleteCourse
	 * @param id
	 * @return
	 */
	@GetMapping("/deletecourse/{id}")
	@Transactional
	public String deleteCourse(@PathVariable("id") Long id) {
		courseService.delete(id);
		return "redirect:/courses";
	}
}
