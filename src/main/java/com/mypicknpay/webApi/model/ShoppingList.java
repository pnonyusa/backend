package com.mypicknpay.webApi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_ShoppingList")
public class ShoppingList  implements Serializable {

	/**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="shoppingList_Id")
	 private Long id;
	
	
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "cart_Id")
	 private ShoppingCart cart;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "productDisp_Id")
	 private ProductDisplay productDisp;
	 
	 
	 
	 private Integer amount;


	 
	 public ShoppingList() {
		 
		 
	 }
	 

	public ShoppingList(ShoppingCart cart, ProductDisplay productDisp, Integer amount){
		this.cart = cart;
		this.productDisp = productDisp;
		this.amount = amount;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public ShoppingCart getCart() {
		return cart;
	}



	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}



	public ProductDisplay getProductDisp() {
		return productDisp;
	}



	public void setProductDisp(ProductDisplay productDisp) {
		this.productDisp = productDisp;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	  

}
