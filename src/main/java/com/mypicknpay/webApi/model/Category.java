package com.mypicknpay.webApi.model;



import java.io.Serializable;
import java.util.List;
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
	
	
	private String name;
	
	
	
	 @NaturalId
	  private Integer categoryType;
	 

	 /*
	  * joins category_tbl and product_tbl
	  * 
	  * */
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "category")
	private Set<Product> products;


	 
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "category")
	 private List<ProductDisplay> productDisplay;
	 
	 
	 
	 //private Date createTime;

	 //private Date updateTime;
	 
	 
	
	



	public Set<Product> getProducts() {
		return products;
	}



	public Category(String name, Integer categoryType, Set<Product> products, List<ProductDisplay> productDisplay) {
		
		this.name = name;
		this.categoryType = categoryType;
		this.products = products;
		this.productDisplay = productDisplay;
	}



	public List<ProductDisplay> getProductDisplay() {
		return productDisplay;
	}



	public void setProductDisplay(List<ProductDisplay> productDisplay) {
		this.productDisplay = productDisplay;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}






	public Category() {
		
		
	}
	
	
	
	 
	 public Long getCat_Id() {
		return cat_Id;
	}



	public void setCat_Id(Long cat_Id) {
		this.cat_Id = cat_Id;
	}



	


	



	public Integer getCategoryType() {
		return categoryType;
	}


	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Category [cat_Id=" + cat_Id + ", name=" + name + ", categoryType=" + categoryType + ", products="
				+ products + ", productDisplay=" + productDisplay + "]";
	}
	
	
	

}
