package com.mypicknpay.webApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypicknpay.webApi.model.ShoppingList;


@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
