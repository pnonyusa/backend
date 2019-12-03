package com.mypicknpay.webApi.model;

import java.io.Serializable;
import java.util.Set;

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


@Entity
@Table(name="tbl_Order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_Id")
	private Long id;
	
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "appUser_Id")
	 private AppUser user;
	
	 
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "order")
	 private Set<OrderList> orderDetails;

	 
	 private String trackingNumber;
	 
	 

	 
	 

	
	
	public Order(Long id, AppUser user, Set<OrderList> orderDetails, String trackingNumber) {
		super();
		this.id = id;
		this.user = user;
		this.orderDetails = orderDetails;
		this.trackingNumber = trackingNumber;
	}




	public Order() {
		
	}



	
	

	public String getTrackingNumber() {
		return trackingNumber;
	}




	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}




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


	public Set<OrderList> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(Set<OrderList> orderDetails) {
		this.orderDetails = orderDetails;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", orderDetails=" + orderDetails + ", trackingNumber="
				+ trackingNumber + "]";
	}
	
	 
	 

}
