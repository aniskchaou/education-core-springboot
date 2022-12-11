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
import com.dev.delta.entities.Payment;
import com.dev.delta.services.PaymentService;
@Controller
public class PaymentController {
	/**
	 * paymentService
	 */
	@Autowired
	private PaymentService paymentService;

	/**
	 * getCountries
	 * @param model
	 * @return
	 */
	@GetMapping("/payments")
	public String getCountries(Model model) {
		List<Payment> countrries = paymentService.getPayments();
		model.addAttribute("payments", countrries);
		return "payment/index";
	}
	
	@RequestMapping("/editpayment/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {

		Payment payment = paymentService.findById(id).get();
		model.addAttribute("payment", payment);

		return "payment/edit";
	}
	
	
	@GetMapping("/addpayment")
	public String addBlogForm(Model model) {
	
		return "payment/add";
	}

	/**
	 * addPayment
	 * @param payment
	 * @param model
	 * @return
	 */
	@PostMapping("/addpayment")
	public String addPayment(Payment payment, Model model) {
		paymentService.save(payment);
		return "redirect:/payments";
	}

	/**
	 * findById
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/payment/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {

		Payment payment = paymentService.findById(id).get();
		model.addAttribute("payment", payment);

		return "payment/view";
	}

	/**
	 * updatePayment
	 * @param id
	 * @param payment
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/updatepayment/{id}")
	public String updatePayment(@PathVariable("id") long id, @Validated Payment payment, 
			BindingResult result,
			Model model) {

		paymentService.save(payment);
		return "redirect:/payments";
	}

	/**
	 * deletePayment
	 * @param id
	 * @return
	 */
	@GetMapping("/deletepayment/{id}")
	@Transactional
	public String deletePayment(@PathVariable("id") Long id) {
		paymentService.delete(id);
		return "redirect:/payments";
	}
}
