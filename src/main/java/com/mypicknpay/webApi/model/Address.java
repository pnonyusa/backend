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
@Table(name="tbl_Address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 995820208296783211L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_Id")
	private Long add_id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appUser_Id")
	private AppUser appUser;
	
	

	private boolean is_Local;
	
	
	private String c_Street_Address;
	
	
	
	private String c_City;
	
	
	
	private int c_Postal_Code;
	
	
	private String c_Province;
	
	
	
	public Address() {}
	
	

	public Address(AppUser appUser, boolean is_Local, String c_Street_Address, String c_City, int c_Postal_Code,
			String c_Province) {
		super();
		this.appUser = appUser;
		this.is_Local = is_Local;
		this.c_Street_Address = c_Street_Address;
		this.c_City = c_City;
		this.c_Postal_Code = c_Postal_Code;
		this.c_Province = c_Province;
	}






	public Long getId() {
		return add_id;
	}

	public void setId(Long add_id) {
		this.add_id = add_id;
	}

	public boolean isIs_Local() {
		return is_Local;
	}

	public void setIs_Local(boolean is_Local) {
		this.is_Local = is_Local;
	}

	public String getC_Street_Address() {
		return c_Street_Address;
	}

	public void setC_Street_Address(String c_Street_Address) {
		this.c_Street_Address = c_Street_Address;
	}

	public String getC_City() {
		return c_City;
	}

	public void setC_City(String c_City) {
		this.c_City = c_City;
	}

	public int getC_Postal_Code() {
		return c_Postal_Code;
	}

	public void setC_Postal_Code(int c_Postal_Code) {
		this.c_Postal_Code = c_Postal_Code;
	}

	public String getC_Province() {
		return c_Province;
	}

	public void setC_Province(String c_Province) {
		this.c_Province = c_Province;
	}
	
	
	
	

}
