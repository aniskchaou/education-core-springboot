package com.dev.delta.dto;

import com.dev.delta.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDTO implements DTO{

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void populate() {
        pay.setName("g");
        pay.setPaymentType("g");
        pay.setValue("dd");
        pay.setDate("d");
        pay.setCourse(course);
        paymentRepository.save(pay);
    }
}
