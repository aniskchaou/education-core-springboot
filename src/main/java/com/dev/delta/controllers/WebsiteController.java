package com.dev.delta.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dev.delta.entities.Subscription;

@Controller
public class WebsiteController {

	@GetMapping("/")
	public String getCountries(Model model) {
		
		return "website/index";
	}
	
	@GetMapping("/coursess")
	public String getCourses(Model model) {
		
		return "website/courses";
	}
	
	@GetMapping("/contact")
	public String getContact(Model model) {
		
		return "website/contact";
	}
	
	@GetMapping("/blog")
	public String getBlog(Model model) {
		
		return "website/blog";
	}
	
	@GetMapping("/single")
	public String getSingleCourse(Model model) {
		
		return "website/single-course";
	}
	
	@GetMapping("/dashboard")
	public String getDashboard(Model model) {
		
		return "dashboard/dashboard";
	}
	
	
}
