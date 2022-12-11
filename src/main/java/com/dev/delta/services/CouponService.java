package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Coupon;
import com.dev.delta.repositories.CouponRepository;
@Service
public class CouponService {
	/**
	 * couponRepository
	 */
	@Autowired
	private CouponRepository couponRepository;
	

	/**
	 * getCoupons
	 * @return
	 */
	public java.util.List<Coupon> getCoupons()
	{
		return couponRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return couponRepository.count();
	}

	/**
	 * save
	 * @param coupon
	 */
	public void save(Coupon coupon)
	{
		couponRepository.save(coupon);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Coupon> findById(Long id) {
		return couponRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		couponRepository.delete(couponRepository.findById(id).get());
	}
}
