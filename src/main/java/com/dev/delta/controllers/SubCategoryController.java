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
import com.dev.delta.entities.SubCategory;
import com.dev.delta.services.SubCategoryService;
@Controller
public class SubCategoryController {
	/**
	 * subCategoryService
	 */
	@Autowired
	private SubCategoryService subCategoryService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/subcategories")
	public String getCountries(Model model) {
		List<SubCategory> countrries = subCategoryService.getSubCategorys();
		model.addAttribute("subCategories", countrries);
		return "subcategory/index";
	}
	
	@GetMapping("/addsubcategory")
	public String addBlogForm(Model model) {
	
		return "subcategory/add";
	}
	
	@RequestMapping("/editsubcategory/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		SubCategory subCategory = subCategoryService.findById(id).get();
		model.addAttribute("subcategory", subCategory);

		return "subcategory/edit";
	}

	/**
	 * addSubCategory
	 * @param subCategory
	 * @param model
	 * @return
	 */
	@PostMapping("/addsubcategory")
	public String addSubCategory(SubCategory subCategory, Model model) {
		subCategoryService.save(subCategory);
		return "redirect:/subcategories";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/subCategory/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		SubCategory subCategory = subCategoryService.findById(id).get();
		model.addAttribute("subCategory", subCategory);

		return "subcategory/view";
	}

	/**
	 * updateSubCategory
	 * @param id
	 * @param subCategory
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatesubcategory/{id}")
	public String updateSubCategory(@PathVariable("id") long id, @Validated SubCategory subCategory, 
			BindingResult result,
			Model model) {

		subCategoryService.save(subCategory);
		return "redirect:/subcategories";
	}

	/**
	 * deleteSubCategory
	 * @param id
	 * @return
	 */
	@GetMapping("/deletesubcategory/{id}")
	@Transactional
	public String deleteSubCategory(@PathVariable("id") Long id) {
		subCategoryService.delete(id);
		return "redirect:/subcategories";
	}
}
