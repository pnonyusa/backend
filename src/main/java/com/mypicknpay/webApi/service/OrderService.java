package com.mypicknpay.webApi.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mypicknpay.webApi.model.AppUser;
import com.mypicknpay.webApi.model.Order;
import com.mypicknpay.webApi.model.OrderList;
import com.mypicknpay.webApi.model.ShoppingCart;
import com.mypicknpay.webApi.model.ShoppingList;
import com.mypicknpay.webApi.repository.AppUserRepository;
import com.mypicknpay.webApi.repository.OrderRepository;

@Service
@Component
@ComponentScan(basePackages= {"com.mypicknpay.webApi.repository","com.mypicknpay.webApi.security.jwt","com.mypicknpay.webApi.security.config"})
public class OrderService {
 
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	AppUserRepository userRepository;
	
	
	      public Order placeOrder(Principal principal,Order order) {
	    	  AppUser user=getUserFromPrincipal(principal);
	    	  
	    	  ShoppingCart cart=user.getCart();
	    	  
	    	  
	    	  if(cart==null) {
	    		  throw new IllegalArgumentException("Cart not found");
	    	  }
	    	  
	    	  List<ShoppingList> cartItem=cart.getShopList();
	    	  
	    	  
	    	  Order saveOrder = new Order();
	    	  
	    	  saveOrder.setUser(user);
	    	  saveOrder.setDate(order.getDate());
	    	  saveOrder.setOrderDetails(new ArrayList<OrderList>());
	    	  
	    	  for(int x=0;x<cartItem.size();x++) {
	    		  cartItem.get(x).getProductDisp().setSellCount(cartItem.get(x).getProductDisp().getSellCount() + cartItem.get(x).getAmount());
	    		  
	    		  OrderList orderDetails=new OrderList();
	    		  
	    		  orderDetails.setAmount(cartItem.get(x).getAmount());
	    		  orderDetails.setOrder(saveOrder);
	    		  orderDetails.setProductDisplay(cartItem.get(x).getProductDisp());
	    		  saveOrder.getOrderDetails().add(orderDetails);
	    	  }
	    	  
	    	  
	    	  orderRepository.save(saveOrder);
	    	  
	    	  return saveOrder;
	      }
	      
	      
	      private AppUser getUserFromPrincipal(Principal principal) {
	    	  
	    	  if(principal==null || principal.getName()==null) {
	    		  
	    		  throw new IllegalArgumentException("Invalid access");
	    	  }
	    	  
	    	  AppUser user=userRepository.findByEmailAddress(principal.getName()).get();
	    	  
	    	  if(user==null) {
	    		  throw new IllegalArgumentException("User not found");
	    	  }
	    	  
	    	  return user;
	      }
	
}
