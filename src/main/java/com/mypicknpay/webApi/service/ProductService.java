package com.mypicknpay.webApi.service;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.mypicknpay.webApi.jwt.response.Response;
import com.mypicknpay.webApi.model.Product;
import com.mypicknpay.webApi.model.login.Products;
import com.mypicknpay.webApi.repository.ProductRepository;

@Service
@Component
@ComponentScan(basePackages= {"com.mypicknpay.webApi.repository"})
public class ProductService {
     
	  @Autowired
	  private ProductRepository prodRepo;
	  
	  public ResponseEntity<?>  addProduct(Products product) throws JsonParseException, JsonMappingException, IOException{
		     
		  Product prod=new Product();
		  if(product!=null) {
			  prod.setPrd_Barcode(product.getPrd_Barcode());
			  prod.setPrd_Count(product.getPrd_Count());
			  prod.setPrd_Description(product.getPrd_Description());
			  prod.setPrd_Name(product.getPrd_Name());
			  prod.setPrd_Price(product.getPrd_Price());
			  prod.setPrd_Unit_Measure(product.getPrd_Unit_Measure());
			  prodRepo.save(prod);
		      return new ResponseEntity<>(new Response("product is successfully! added"), HttpStatus.OK); 
		  } 
			  return new ResponseEntity<>(new Response("product is unsuccessfully! added"), HttpStatus.BAD_REQUEST);
		   
	  }
	
	

}
	  
	  
	  
	  
		/*//update product by product name
		public boolean updateProduct(String prd_Name,Product prod) {
			Product existProduct=productRepository.getProductByPrd_Name(prd_Name).get();
			if(existProduct!=null) {
				existProduct=prod;
				productRepository.save(existProduct);
				return true;
			}
			return false;	
		}
		
		
		
		//removes product by product name
		public boolean removeProduct(String prd_Name) {
			Product existProduct=productRepository.getProductByPrd_Name(prd_Name).get();
			if(existProduct!=null) {
				productRepository.delete(existProduct);
				return true;
			}
			return false;	
		}*/
	
	

