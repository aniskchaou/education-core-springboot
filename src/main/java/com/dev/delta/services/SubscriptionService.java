package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Subscription;
import com.dev.delta.repositories.SubscriptionRepository;
@Service
public class SubscriptionService {
	/**
	 * subscriptionRepository
	 */
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	

	/**
	 * getSubscriptions
	 * @return
	 */
	public java.util.List<Subscription> getSubscriptions()
	{
		return subscriptionRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return subscriptionRepository.count();
	}

	/**
	 * save
	 * @param subscription
	 */
	public void save(Subscription subscription)
	{
		subscriptionRepository.save(subscription);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Subscription> findById(Long id) {
		return subscriptionRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		subscriptionRepository.delete(subscriptionRepository.findById(id).get());
	}
}
