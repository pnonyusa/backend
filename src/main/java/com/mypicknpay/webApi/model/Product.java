package com.mypicknpay.webApi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;






@Entity
@Table(name="tbl_Product")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_Id")
	private Long prd_id;
	
	private String prd_Barcode;
	
	private String prd_Name;
	
	private double prd_Price;
	
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "product_Id",referencedColumnName = "img_Id")
	private ProductImage productImg;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_Id")
	private Category category;


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	private boolean prd_Is_Avail;

	private int prd_Count;
	private double prd_Unit_Measure;
	
	private String prd_Description;
	
	private boolean prd_Promo;

	
	


	
	public ProductImage getProductImg() {
		return productImg;
	}


	public void setProductImg(ProductImage productImg) {
		this.productImg = productImg;
	}
	
	



	public Long getPrd_id() {
		return prd_id;
	}


	public void setPrd_id(Long prd_id) {
		this.prd_id = prd_id;
	}


	public String getPrd_Barcode() {
		return prd_Barcode;
	}


	public void setPrd_Barcode(String prd_Barcode) {
		this.prd_Barcode = prd_Barcode;
	}


	public String getPrd_Name() {
		return prd_Name;
	}


	public void setPrd_Name(String prd_Name) {
		this.prd_Name = prd_Name;
	}





	public double getPrd_Price() {
		return prd_Price;
	}


	public void setPrd_Price(double prd_Price) {
		this.prd_Price = prd_Price;
	}


	public boolean isPrd_Is_Avail() {
		return prd_Is_Avail;
	}


	public void setPrd_Is_Avail(boolean prd_Is_Avail) {
		this.prd_Is_Avail = prd_Is_Avail;
	}


	public int getPrd_Count() {
		return prd_Count;
	}


	public void setPrd_Count(int prd_Count) {
		this.prd_Count = prd_Count;
	}


	public double getPrd_Unit_Measure() {
		return prd_Unit_Measure;
	}


	public void setPrd_Unit_Measure(double prd_Unit_Measure) {
		this.prd_Unit_Measure = prd_Unit_Measure;
	}


	public String getPrd_Description() {
		return prd_Description;
	}


	public void setPrd_Description(String prd_Description) {
		this.prd_Description = prd_Description;
	}


	public boolean isPrd_Promo() {
		return prd_Promo;
	}


	public void setPrd_Promo(boolean prd_Promo) {
		this.prd_Promo = prd_Promo;
	}


	@Override
	public String toString() {
		return "Product [prd_id=" + prd_id + ", prd_Barcode=" + prd_Barcode + ", prd_Name=" + prd_Name + ", prd_Price="
				+ prd_Price + ", productImg=" + productImg + ", category=" + category + ", prd_Is_Avail=" + prd_Is_Avail
				+ ", prd_Count=" + prd_Count + ", prd_Unit_Measure=" + prd_Unit_Measure + ", prd_Description="
				+ prd_Description + ", prd_Promo=" + prd_Promo + "]";
	}


	
	
}
