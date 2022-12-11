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
import com.dev.delta.entities.Student;
import com.dev.delta.services.StudentService;
@Controller
public class StudentController {
	/**
	 * studentService
	 */
	@Autowired
	private StudentService studentService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/students")
	public String getCountries(Model model) {
		List<Student> countrries = studentService.getStudents();
		model.addAttribute("students", countrries);
		return "student/index";
	}
	
	@GetMapping("/addstudent")
	public String addBlogForm(Model model) {
	
		return "student/add";
	}
	
	@RequestMapping("/editstudent/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Student student = studentService.findById(id).get();
		model.addAttribute("student", student);

		return "student/edit";
	}
	

	/**
	 * addStudent
	 * @param student
	 * @param model
	 * @return
	 */
	@PostMapping("/addstudent")
	public String addStudent(Student student, Model model) {
		studentService.save(student);
		return "redirect:/students";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Student student = studentService.findById(id).get();
		model.addAttribute("student", student);

		return "student/view";
	}

	/**
	 * updateStudent
	 * @param id
	 * @param student
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatestudent/{id}")
	public String updateStudent(@PathVariable("id") long id, @Validated Student student, 
			BindingResult result,
			Model model) {

		studentService.save(student);
		return "redirect:/students";
	}

	/**
	 * deleteStudent
	 * @param id
	 * @return
	 */
	@GetMapping("/deletestudent/{id}")
	@Transactional
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.delete(id);
		return "redirect:/students";
	}
}
