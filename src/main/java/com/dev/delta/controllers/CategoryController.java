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
import com.dev.delta.services.CategoryService;
@Controller
public class CategoryController {
	/**
	 * categoryService
	 */
	@Autowired
	private CategoryService categoryService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/categories")
	public String getCountries(Model model) {
		List<Category> categories = categoryService.getCategorys();
		model.addAttribute("categories", categories);
		return "category/index";
	}
	
	@GetMapping("/addcategory")
	public String addBlogForm(Model model) {
	
		return "category/add";
	}

	/**
	 * addCategory
	 * @param category
	 * @param model
	 * @return
	 */
	@PostMapping("/addcategory")
	public String addCategory(Category category, Model model) {
		categoryService.save(category);
		return "redirect:/categories";
	}
	
	
	
	/**
	 * addCategory
	 * @param category
	 * @param model
	 * @return
	 */
	/*
	 * @GetMapping("/addcategory") public String addCategoryForm( Model model) {
	 * //categoryService.save(category); return "category/add"; }
	 */
	
	

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/category/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Category category = categoryService.findById(id).get();
		model.addAttribute("category", category);

		return "category/view";
	}
	
	
	@RequestMapping("/editcategory/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Category category = categoryService.findById(id).get();
		model.addAttribute("category", category);

		return "category/edit";
	}

	/**
	 * updateCategory
	 * @param id
	 * @param category
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatecategory/{id}")
	public String updateCategory(@PathVariable("id") long id, @Validated Category category, 
			BindingResult result,
			Model model) {

		categoryService.save(category);
		return "redirect:/categories";
	}

	/**
	 * deleteCategory
	 * @param id
	 * @return
	 */
	@GetMapping("/deletecategory/{id}")
	@Transactional
	public String deleteCategory(@PathVariable("id") Long id) {
		categoryService.delete(id);
		return "redirect:/categories";
	}
}
