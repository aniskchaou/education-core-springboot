package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.delta.entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

}
