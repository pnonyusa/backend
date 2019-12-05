package com.mypicknpay.webApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypicknpay.webApi.model.OrderList;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
      
}
