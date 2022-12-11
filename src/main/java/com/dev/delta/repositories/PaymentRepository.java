package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Payment;

public interface PaymentRepository  extends JpaRepository<Payment, Long>{

}
