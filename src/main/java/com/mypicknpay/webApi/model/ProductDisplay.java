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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="tbl_ProductDisplay")
public class ProductDisplay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productDisp_Id")
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_Id")
	private Category category;
	
	
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "productDisplay")
	private List<OrderList> orderLists;
	
	 
	 
	 
	private String name;
	
	private Float price;
	
	private Integer sellCount;
	
	
	private Float cargoPrice;
	
	private String thumb;
	
	
	private String dateCreated;


	
	
	
	
	public ProductDisplay(Category category, List<OrderList> orderLists, String name, Float price, Integer sellCount,
			Float cargoPrice, String thumb, String dateCreated) {
		super();
		this.category = category;
		this.orderLists = orderLists;
		this.name = name;
		this.price = price;
		this.sellCount = sellCount;
		this.cargoPrice = cargoPrice;
		this.thumb = thumb;
		this.dateCreated = dateCreated;
	}

	
	

	public ProductDisplay() {
		
	}




	public List<OrderList> getOrderLists() {
		return orderLists;
	}


	public void setOrderLists(List<OrderList> orderLists) {
		this.orderLists = orderLists;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public Integer getSellCount() {
		return sellCount;
	}


	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}


	public Float getCargoPrice() {
		return cargoPrice;
	}


	public void setCargoPrice(Float cargoPrice) {
		this.cargoPrice = cargoPrice;
	}


	public String getThumb() {
		return thumb;
	}


	public void setThumb(String thumb) {
		this.thumb = thumb;
	}


	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Override
	public String toString() {
		return "ProductDisplay [id=" + id + ", category=" + category + ", orderLists=" + orderLists + ", name=" + name
				+ ", price=" + price + ", sellCount=" + sellCount + ", cargoPrice=" + cargoPrice + ", thumb=" + thumb
				+ ", dateCreated=" + dateCreated + "]";
	}
	
	
		
}
