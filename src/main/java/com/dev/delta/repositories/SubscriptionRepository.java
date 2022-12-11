package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
