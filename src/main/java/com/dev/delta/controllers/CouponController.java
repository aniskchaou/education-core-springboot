package com.dev.delta.controllers;

import java.util.List;

import javax.transaction.Transactional;

import com.dev.delta.entities.Course;
import com.dev.delta.services.CourseService;
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
import com.dev.delta.entities.Coupon;
import com.dev.delta.services.CouponService;
@Controller
public class CouponController {
	/**
	 * couponService
	 */
	@Autowired
	private CouponService couponService;

	@Autowired
	CourseService courseService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/coupons")
	public String getCountries(Model model) {
		List<Coupon> coupons = couponService.getCoupons();
		model.addAttribute("coupons", coupons);
		List<Course> countrries = courseService.getCourses();
		model.addAttribute("courses", countrries);
		return "coupon/index";
	}
	
	@GetMapping("/addcoupon")
	public String addBlogForm(Model model) {
		List<Course> countrries = courseService.getCourses();
		model.addAttribute("courses", countrries);
	
		return "coupon/add";
	}
	
	
	@RequestMapping("/editcoupon/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Coupon coupon = couponService.findById(id).get();
		model.addAttribute("coupon", coupon);
		List<Course> countrries = courseService.getCourses();
		model.addAttribute("courses", countrries);

		return "coupon/edit";
	}

	/**
	 * addCoupon
	 * @param coupon
	 * @param model
	 * @return
	 */
	@PostMapping("/addcoupon")
	public String addCoupon(Coupon coupon, Model model) {
		couponService.save(coupon);
		return "redirect:/coupons";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/coupon/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Coupon coupon = couponService.findById(id).get();
		model.addAttribute("coupon", coupon);

		return "coupon/view";
	}

	/**
	 * updateCoupon
	 * @param id
	 * @param coupon
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatecoupon/{id}")
	public String updateCoupon(@PathVariable("id") long id, @Validated Coupon coupon, 
			BindingResult result,
			Model model) {

		couponService.save(coupon);
		return "redirect:/coupons";
	}

	/**
	 * deleteCoupon
	 * @param id
	 * @return
	 */
	@GetMapping("/deletecoupon/{id}")
	@Transactional
	public String deleteCoupon(@PathVariable("id") Long id) {
		couponService.delete(id);
		return "redirect:/coupons";
	}
}
