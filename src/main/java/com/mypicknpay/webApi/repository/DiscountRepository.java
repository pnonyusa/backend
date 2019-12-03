package com.mypicknpay.webApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypicknpay.webApi.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
	
}
