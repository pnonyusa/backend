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
@Table(name="tbl_OrderList")
public class OrderList implements Serializable {
     
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderlist_Id")
	private Long id;
	
	
	
	/*
	 * joins order and order list tables
	 * 
	 * */
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "order_Id")
	 private Order order;
	 
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "productDisp_Id")
	 private ProductDisplay productDisplay;
	 
	 
	 
	 
	 private Integer amount;


	 
	 
	 


	public OrderList(Order order, ProductDisplay productDisplay, Integer amount) {
	
		this.order = order;
		this.productDisplay = productDisplay;
		this.amount = amount;
	}
	
	
	public OrderList() {
	
	}







	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Order getOrder() {
		return order;
	}




	public void setOrder(Order order) {
		this.order = order;
	}




	public ProductDisplay getProductDisplay() {
		return productDisplay;
	}




	public void setProductDisplay(ProductDisplay productDisplay) {
		this.productDisplay = productDisplay;
	}




	public Integer getAmount() {
		return amount;
	}




	public void setAmount(Integer amount) {
		this.amount = amount;
	}




	@Override
	public String toString() {
		return "OrderList [id=" + id + ", order=" + order + ", productDisplay=" + productDisplay + ", amount=" + amount
				+ "]";
	}
	 
	 
	
	
	
	
}
