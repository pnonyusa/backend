package com.mypicknpay.webApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypicknpay.webApi.model.ProductImage;

@Repository
public interface ImageRepository extends JpaRepository<ProductImage, Long> {
}
