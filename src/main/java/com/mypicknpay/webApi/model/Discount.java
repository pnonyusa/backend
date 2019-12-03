package com.mypicknpay.webApi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Discount")
public class Discount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="discount_Id")
	private Long id;
	
	
	@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "cartDisc")
	private List<ShoppingCart> cartList;
	
	
	
	private String code;
	
	private Integer discountPercent;
	
	
	private Integer status;


	public Discount(List<ShoppingCart> cartList, String code, Integer discountPercent, Integer status) {
		super();
		this.cartList = cartList;
		this.code = code;
		this.discountPercent = discountPercent;
		this.status = status;
	}


	public Discount() {
	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<ShoppingCart> getCartList() {
		return cartList;
	}


	public void setCartList(List<ShoppingCart> cartList) {
		this.cartList = cartList;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Integer getDiscountPercent() {
		return discountPercent;
	}


	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Discount [id=" + id + ", cartList=" + cartList + ", code=" + code + ", discountPercent="
				+ discountPercent + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
}
