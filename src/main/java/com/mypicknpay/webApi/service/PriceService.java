package com.mypicknpay.webApi.service;

import org.springframework.stereotype.Service;

import com.mypicknpay.webApi.model.ShoppingCart;

@Service
public class PriceService {
	
	
	
	
	public PriceService() {
		
	}
	

	public ShoppingCart calculateCart(ShoppingCart cart) {
		
		Float totalPrice=0f;
		Float totalCargoPrice=0f;
		
		for(int i=0;i<cart.getShopList().size();i++) {
			totalPrice+=((cart.getShopList().get(i).getProductDisp().getPrice()+cart.getShopList().get(i).getProductDisp().getCargoPrice())*cart.getShopList().get(i).getAmount());
			totalCargoPrice+=(cart.getShopList().get(i).getProductDisp().getCargoPrice()*cart.getShopList().get(i).getAmount());
		}
		
		if(cart.getCartDisc()!=null) {
			
			totalPrice=totalPrice-((totalPrice*cart.getCartDisc().getDiscountPercent())/100);
		}
		
		
		cart.setTotalPrice(roundTwoPlaces(totalPrice));
		cart.setTotalNetPrice(roundTwoPlaces(totalCargoPrice));
		
		return cart;
		
	}
	
	
	
	private float roundTwoPlaces(float d) {
		return Math.round(d*100)/100;
	}

}
