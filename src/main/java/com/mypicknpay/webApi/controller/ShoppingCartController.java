package com.mypicknpay.webApi.controller;

import java.io.IOException;
import java.security.Principal;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypicknpay.webApi.model.ShoppingCart;
import com.mypicknpay.webApi.service.ShoppingCartService;


@ComponentScan(basePackages= {"com.mypicknpay.webApi.service","com.mypicknpay.webApi.security.config"})
@Controller
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping("/picknpay")
public class ShoppingCartController {
	
    @Autowired
    private ShoppingCartService cartService;
    
    
    @PermitAll
	@PostMapping("/cart")
    public ResponseEntity<ShoppingCart> addToCart(@RequestBody String payLoad,Principal principal) throws IOException{
    	
    	ObjectMapper mapper =new ObjectMapper();
    	
    	JsonNode realObject=mapper.readTree(payLoad);
        
    	JsonNode jsonNode1 =realObject.get("product_Id");
    	
    	JsonNode jsonNode2=realObject.get("amount");
    	
    	Long requestedId=Long.parseLong(jsonNode1.textValue());
    	
    	Integer requestedAmt=Integer.parseInt(jsonNode2.textValue());
    	
    	ShoppingCart cart=cartService.addToShoppingCart(principal, requestedId, requestedAmt);
    	
    	
		return new ResponseEntity<ShoppingCart>(cart,HttpStatus.OK);
    }
    
    
}
