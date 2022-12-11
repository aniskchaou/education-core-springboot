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

import com.dev.delta.entities.Blog;
import com.dev.delta.entities.Category;
import com.dev.delta.services.BlogService;
@Controller
public class BlogController {
	/**
	 * blogService
	 */
	@Autowired
	private BlogService blogService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/blogs")
	public String getBlogs(Model model) {
		List<Blog> blogs = blogService.getBlogs();
		model.addAttribute("blogs", blogs);
		return "blog/index";
	}
	
	@GetMapping("/addblog")
	public String addBlogForm(Model model) {
	
		return "blog/add";
	}
	
	@RequestMapping("/editblog/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Blog blog = blogService.findById(id).get();
		model.addAttribute("blog", blog);

		return "blog/edit";
	}

	/**
	 * addBlog
	 * @param blog
	 * @param model
	 * @return
	 */
	@PostMapping("/addblog")
	public String addBlog(Blog blog, Model model) {
		blogService.save(blog);
		return "redirect:/blogs";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/blog/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Blog blog = blogService.findById(id).get();
		model.addAttribute("blog", blog);

		return "blog/view";
	}

	/**
	 * updateBlog
	 * @param id
	 * @param blog
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updateblog/{id}")
	public String updateBlog(@PathVariable("id") long id, @Validated Blog blog, 
			BindingResult result,
			Model model) {

		blogService.save(blog);
		return "redirect:/blogs";
	}

	/**
	 * deleteBlog
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteblog/{id}")
	@Transactional
	public String deleteBlog(@PathVariable("id") Long id) {
		blogService.delete(id);
		return "redirect:/blogs";
	}
}
