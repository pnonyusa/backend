package com.mypicknpay.webApi.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mypicknpay.webApi.model.AppUser;
import com.mypicknpay.webApi.model.ProductDisplay;
import com.mypicknpay.webApi.model.ShoppingCart;
import com.mypicknpay.webApi.model.ShoppingList;
import com.mypicknpay.webApi.repository.AppUserRepository;
import com.mypicknpay.webApi.repository.OrderListRepository;
import com.mypicknpay.webApi.repository.OrderRepository;
import com.mypicknpay.webApi.repository.ProductDisplayRepository;
import com.mypicknpay.webApi.repository.ShoppingCartRepository;
import com.mypicknpay.webApi.repository.ShoppingListRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
@ComponentScan(basePackages= {"com.mypicknpay.webApi.repository","com.mypicknpay.webApi.security.jwt","com.mypicknpay.webApi.security.config"})
public class ShoppingCartService {

	@Autowired
	private ProductService productService;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private AppUserRepository userRepository;
	
	
	@Autowired
	private OrderListRepository orderListRepo;
	
	@Autowired
	private ShoppingCartRepository cartRepository;
	
	@Autowired
	private AppUserService userService;
	
	@Autowired
	private PriceService priceService;
	
	@Autowired
	private ProductDisplayRepository productDisplayRepository;
	
	@Autowired
	private ShoppingListRepository shoppingListRepo;
	
	
	
	
	
	/**
	 * The method will add the products to cart
	 * 
	 * */
	
	public ShoppingCart addToShoppingCart(Principal principal, Long id, Integer amount) {
		AppUser user=getUserFromPrinciple(principal);
		
		if(id<=0 || amount<=0 ) {
			
			throw new IllegalArgumentException("Invalid parameters");
		}
		
		
		ShoppingCart cart=user.getCart();
		
		if(cart==null) {
			cart=new ShoppingCart();
			cart.setUser(user);
		}else if(cart.getShopList()!=null ||!cart.getShopList().isEmpty() ) {
			
			for(int x=0;x<cart.getShopList().size();x++) {
				
				if(cart.getShopList().get(x).getId().equals(id)){
					cart.getShopList().get(x).setAmount(cart.getShopList().get(x).getAmount()+amount);
					
					ShoppingCart returnCart=priceService.calculateCart(cart);
					
					cartRepository.save(returnCart);
					
					return returnCart;
				}
				
			}
			  
		}
		
		
		Optional optional=productDisplayRepository.findById(id);
		
		
		if(!optional.isPresent()) {
			throw new IllegalArgumentException("Product not found");
		}
		
		
		ProductDisplay product= (ProductDisplay) optional.get();
		
		ShoppingList cartItem=new ShoppingList();
		
		cartItem.setAmount(amount);
		cartItem.setProductDisp(product);
		
		cartItem.setCart(cart);
		
		
		if(cart.getShopList()==null) {
			cart.setShopList(new ArrayList<>());
		}
		
		cart.getShopList().add(cartItem);
		
		cart=priceService.calculateCart(cart);
		
		shoppingListRepo.save(cartItem);
		
		
		
		return cart;
	}
	
	
	
	/**
	 * The method remove the products from   cart
	 * 
	 * */
	public ShoppingCart removeItemFromCart(Principal principal,Long id) {
		
		AppUser user=getUserFromPrinciple(principal);
		ShoppingCart cart=user.getCart();
		
		if(cart==null) {
			
			throw new IllegalArgumentException("Cart not found");
		}
		
		List<ShoppingList> cartItem =cart.getShopList();
		ShoppingList cartItemToDelete=null;
		
		for(int x=0;x<cartItem.size();x++) {
			
			if(cartItem.get(x).getId().equals(id)) {
				
				cartItemToDelete=cartItem.get(x);
			}
		}
		
		if(cartItemToDelete==null) {
			
			throw new IllegalArgumentException("CartItem not found");
		}
		
		
		cartItem.remove(cartItemToDelete);
		
		if(cart.getShopList()==null || cart.getShopList().size()==0) {
			user.setCart(null);
			userRepository.save(user);
		}
		
		cart.setShopList(cartItem);
		cart=priceService.calculateCart(cart);
		
		shoppingListRepo.delete(cartItemToDelete);
		
		
		return cart;
	}
	
	
	
	
	
	
	
	private AppUser getUserFromPrinciple(Principal principal) {
		
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
