package com.dev.delta;

import com.dev.delta.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.delta.entities.Coupon;

@SpringBootApplication
public class SpringbootEducationCoreCodecanyonApplication implements CommandLineRunner {

	@Autowired
	UserDTO  userDTO;
	
	@Autowired
	RoleDTO roleDTO;
	
	@Autowired
	CategoryDTO categoryDTO;
	
	@Autowired
	CouponDTO couponDTO;

	@Autowired
	PaymentDTO paymentDTO;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootEducationCoreCodecanyonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		roleDTO.populate();
		userDTO.populate();

		
		
	}

}
