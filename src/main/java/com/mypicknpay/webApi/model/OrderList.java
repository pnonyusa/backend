package com.mypicknpay.webApi.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrderList {
     
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderlist_Id")
	private Long id;
	
	
	
	
	
}
