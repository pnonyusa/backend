package com.mypicknpay.webApi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;






@Entity
@Table(name="tbl_role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7870352724513966325L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_Id")
	private Long role_Id;
	
	
	
	
	public Role() {}
	
	 
	 private String  roleName;
	
	
	 @ManyToMany(mappedBy="roles")
	 private Set<AppUser> user;

	

	public Set<AppUser> getUser() {
		return user;
	}

	public void setUser(Set<AppUser> user) {
		this.user = user;
	}

	public Long getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(Long role_Id) {
		this.role_Id = role_Id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return "Role [role_Id=" + role_Id + ", roleName=" + roleName + "]";
	}

	
}
