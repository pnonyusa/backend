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
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.NaturalId;



@Entity
@Table(name="tbl_ProductCategory")
public class Category implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_Id")
	private Long cat_Id;
	
	
	private String categoryName;
	
	
	
	 @NaturalId
	  private Integer categoryType;
	 

	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "category")
	private Set<Product> products;


	 //private Date createTime;

	 //private Date updateTime;
	 
	 
	
	



	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}



	public Category(String categoryName, Integer categoryType) {
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}



	public Category() {
		
		
	}
	
	
	
	
	
	 
	 public Long getCat_Id() {
		return cat_Id;
	}



	public void setCat_Id(Long cat_Id) {
		this.cat_Id = cat_Id;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public Integer getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
	
	
	@Override
	public String toString() {
		return "Category [cat_Id=" + cat_Id + ", categoryName=" + categoryName + ", categoryType=" + categoryType
				+ ", products=" + products + "]";
	}

}
