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
import com.dev.delta.entities.Subscription;
import com.dev.delta.services.SubscriptionService;
@Controller
public class SubscriptionController {
	/**
	 * subscriptionService
	 */
	@Autowired
	private SubscriptionService subscriptionService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/subscriptions")
	public String getCountries(Model model) {
		List<Subscription> countrries = subscriptionService.getSubscriptions();
		model.addAttribute("subscriptions", countrries);
		return "subscription/index";
	}
	
	@GetMapping("/addsubscription")
	public String addBlogForm(Model model) {
	
		return "subscription/add";
	}
	
	@RequestMapping("/editsubscription/{id}")
	public String editBlog(@PathVariable("id") Long id, Model model) {

		Subscription subscription = subscriptionService.findById(id).get();
		model.addAttribute("subscription", subscription);

		return "subscription/edit";
	}

	/**
	 * addSubscription
	 * @param subscription
	 * @param model
	 * @return
	 */
	@PostMapping("/addsubscription")
	public String addSubscription(Subscription subscription, Model model) {
		subscriptionService.save(subscription);
		return "redirect:/subscriptions";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/subscription/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Subscription subscription = subscriptionService.findById(id).get();
		model.addAttribute("subscription", subscription);

		return "editSubscription";
	}

	/**
	 * updateSubscription
	 * @param id
	 * @param subscription
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatesubscription/{id}")
	public String updateSubscription(@PathVariable("id") long id, @Validated Subscription subscription, 
			BindingResult result,
			Model model) {

		subscriptionService.save(subscription);
		return "redirect:/subscriptions";
	}

	/**
	 * deleteSubscription
	 * @param id
	 * @return
	 */
	@GetMapping("/deletesubscription/{id}")
	@Transactional
	public String deleteSubscription(@PathVariable("id") Long id) {
		subscriptionService.delete(id);
		return "redirect:/subscriptions";
	}
}
