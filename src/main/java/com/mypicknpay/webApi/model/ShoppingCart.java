package com.mypicknpay.webApi.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import java.util.List;


@Entity
@Table(name="tbl_ShoppingCart")
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
	 
	 
	 
	 
	 
	 public ShoppingCart(Discount cartDisc, List<ShoppingList> shopList, double totalPrice, double totalNetPrice,
			Date dateCreated) {
		
		this.cartDisc = cartDisc;
		this.shopList = shopList;
		this.totalPrice = totalPrice;
		this.totalNetPrice = totalNetPrice;
		this.dateCreated = dateCreated;
	}


	

	 
	 public ShoppingCart() {
		 
		 
	 }

	 public Long getId() {
		return id;
	 }
	 
	 
	public void setId(Long id) {
		this.id = id;
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
