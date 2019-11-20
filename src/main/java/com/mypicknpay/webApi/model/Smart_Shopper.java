package com.mypicknpay.webApi.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_Smart_Shopper")
public class Smart_Shopper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="smart_Id")
	private Long smart_Id;
	
	
	

	
	private String c_CardNumber;
	
	
	
	public Smart_Shopper() {}
	
	
	
	public Long getId() {
		return smart_Id;
	}

	public void setId(Long smart_Id) {
		this.smart_Id = smart_Id;
	}

	public String getC_CardNumber() {
		return c_CardNumber;
	}

	public void setC_CardNumber(String c_CardNumber) {
		this.c_CardNumber = c_CardNumber;
	}

	
	
	
	

}
