package com.mypicknpay.webApi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	 
	 
	 private ProductDisplay productDisp;
	 
	 
	 
	 private Integer amount;
	 
	 
	 
	 
	 
	 

}
