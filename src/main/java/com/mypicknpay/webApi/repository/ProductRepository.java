package com.mypicknpay.webApi.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.mypicknpay.webApi.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
          
         /*Optional<Product>getProductByPrd_Name(String prd_Name);
         boolean updateProduct(String prd_Name,Product prod);
         boolean removeProduct(String prd_Name);
         boolean removeProducts(String catType);*/
}
