package com.mypicknpay.webApi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class ShoppingCart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_Id")
	private Long id;
	
	/*
	 *every single user can be able to single cart 
	 * */
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     @JoinColumn(name = "appUser_Id",referencedColumnName = "cart_Id")
	 private AppUser user;
	 
	 
	 /*
	  * joining discount and shopping cart
	  * */
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "discount_Id")
	 private Discount cartDisc;
	 
	 
	 /*
	  * one to many relationship list and cart
	  * 
	  * */
	 
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "cart")
	 private List<ShoppingList> shopList;
	 
	 
	 
	 private double totalPrice;
	 
	 
	 private double totalNetPrice;
	 private Date dateCreated;
	 
	 
	 
	 
	 
	 public Long getId() {
		return id;
	 }
	 
	 
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public AppUser getUser() {
		return user;
	}
	
	
	public void setUser(AppUser user) {
		this.user = user;
	}
	
	
	public Discount getCartDisc() {
		return cartDisc;
	}
	
	
	public void setCartDisc(Discount cartDisc) {
		this.cartDisc = cartDisc;
	}
	
	
	public List<ShoppingList> getShopList() {
		return shopList;
	}
	
	
	public void setShopList(List<ShoppingList> shopList) {
		this.shopList = shopList;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalNetPrice() {
		return totalNetPrice;
	}
	public void setTotalNetPrice(double totalNetPrice) {
		this.totalNetPrice = totalNetPrice;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	

}
