package com.mypicknpay.webApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypicknpay.webApi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByCategoryName(String categoryName);
	
	List<Category> findAllByOrderCategoryName();
	
}
