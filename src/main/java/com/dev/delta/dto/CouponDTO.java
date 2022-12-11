package com.dev.delta.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.repositories.CouponRepository;

@Service
public class CouponDTO implements DTO {

	@Autowired
	CouponRepository  couponRepository ;
	
	@Override
	public void populate() {
		// TODO Auto-generated method stub
        coupon.setCode("sdf");
        coupon.setDiscount("se");
        coupon.setLimit("sf");
        coupon.setName("sdf");
        couponRepository.save(coupon);
	}

}
