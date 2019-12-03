package com.mypicknpay.webApi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mypicknpay.webApi.model.Category;
import com.mypicknpay.webApi.model.ProductDisplay;



@Repository
public interface ProductDisplayRepository extends PagingAndSortingRepository<ProductDisplay, Long> {
        List<ProductDisplay> findAllByCategory(Pageable pageable,Category category);
}
