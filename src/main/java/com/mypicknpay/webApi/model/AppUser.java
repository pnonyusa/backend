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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;













@Entity
@Table(name="tbl_AppUser")
public class AppUser implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appUser_Id")
	private Long c_id;
	
	
	private String name;
	
	
	private String c_Surname;
	
	
	private String c_Password;
	
	
	private String emailAddress;
	

	private String c_Cell_Number;
	
	
	private String c_Home_Number;
	
	
	private String c_Id_Num;
	  

	
	


	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "appUser")
	private Set<Address> address;
    
    
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "appUser_Id",referencedColumnName = "smart_Id")
    private Smart_Shopper smart_card;
    
    
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "appUser_Id",referencedColumnName = "cart_Id")
    private ShoppingCart cart;
	
	
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "user")
	 private Set<Order> orders;
   


    //join app user and roles
    
    @ManyToMany(cascade= {CascadeType.ALL},fetch=FetchType.LAZY)
    @JoinTable(name="tbl_appUser_role", joinColumns= {@JoinColumn(name="appUser_Id")},inverseJoinColumns= {@JoinColumn(name="role_Id")})
    private Set<Role> roles;

    
    public AppUser() {}
    
    



	

	
	public AppUser(String name, String c_Surname, String c_Password, String emailAddress, String c_Cell_Number,
			String c_Home_Number, String c_Id_Num, Set<Address> address, Smart_Shopper smart_card, Set<Order> orders,
			Set<Role> roles, int active) {
		super();
		this.name = name;
		this.c_Surname = c_Surname;
		this.c_Password = c_Password;
		this.emailAddress = emailAddress;
		this.c_Cell_Number = c_Cell_Number;
		this.c_Home_Number = c_Home_Number;
		this.c_Id_Num = c_Id_Num;
		this.address = address;
		this.smart_card = smart_card;
		this.orders = orders;
		this.roles = roles;
		this.active = active;
	}








	public Set<Order> getOrders() {
		return orders;
	}



	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}


	public Smart_Shopper getSmart_card() {
		return smart_card;
	}

	public void setSmart_card(Smart_Shopper smart_card) {
		this.smart_card = smart_card;
	}

	private int active;
	
	
    public Set<Address> getAddress() {
		return address;
	}


	public void setAddress(Set<Address> address) {
		this.address = address;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	


	public Long getC_id() {
		return c_id;
	}


	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getC_Surname() {
		return c_Surname;
	}


	public void setC_Surname(String c_Surname) {
		this.c_Surname = c_Surname;
	}


	public String getC_Password() {
		return c_Password;
	}


	public void setC_Password(String c_Password) {
		this.c_Password = c_Password;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getC_Cell_Number() {
		return c_Cell_Number;
	}


	public void setC_Cell_Number(String c_Cell_Number) {
		this.c_Cell_Number = c_Cell_Number;
	}


	public String getC_Home_Number() {
		return c_Home_Number;
	}


	public void setC_Home_Number(String c_Home_Number) {
		this.c_Home_Number = c_Home_Number;
	}


	public String getC_Id_Num() {
		return c_Id_Num;
	}


	public void setC_Id_Num(String c_Id_Num) {
		this.c_Id_Num = c_Id_Num;
	}


	


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}



	@Override
	public String toString() {
		return "AppUser [c_id=" + c_id + ", name=" + name + ", c_Surname=" + c_Surname + ", c_Password=" + c_Password
				+ ", emailAddress=" + emailAddress + ", c_Cell_Number=" + c_Cell_Number + ", c_Home_Number="
				+ c_Home_Number + ", c_Id_Num=" + c_Id_Num + ", address=" + address + ", smart_card=" + smart_card
				+ ", orders=" + orders + ", roles=" + roles + ", active=" + active + "]";
	}


	
	
	
	
	

}
