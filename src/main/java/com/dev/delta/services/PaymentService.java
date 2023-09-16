package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Paymentt;
import com.dev.delta.repositories.PaymentRepository;
@Service
public class PaymentService {
	/**
	 * paymentRepository
	 */
	@Autowired
	private PaymentRepository paymentRepository;
	

	/**
	 * getPayments
	 * @return
	 */
	public java.util.List<Paymentt> getPayments()
	{
		return paymentRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return paymentRepository.count();
	}

	/**
	 * save
	 * @param payment
	 */
	public void save(Paymentt payment)
	{
		paymentRepository.save(payment);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Paymentt> findById(Long id) {
		return paymentRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		paymentRepository.delete(paymentRepository.findById(id).get());
	}
}
