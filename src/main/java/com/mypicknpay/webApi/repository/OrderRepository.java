package com.mypicknpay.webApi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mypicknpay.webApi.model.AppUser;
import com.mypicknpay.webApi.model.Order;

import org.springframework.data.domain.Pageable;

/**
 * Sorting
 * Spring Data JPA provides a Sort object in order to provide a sorting mechanism
 * Paging-limits application to fetch whole data on database
 */

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
       List<Order> findAllByUserOrderByDateDesc(AppUser user,Pageable pageable);
       Integer countAllByUser(AppUser user);   
}
