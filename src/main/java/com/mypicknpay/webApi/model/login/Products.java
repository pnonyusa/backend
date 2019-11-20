package com.mypicknpay.webApi.model.login;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class Products {
	private String prd_Barcode;
	
	private String prd_Name;
	
	private double prd_Price;
	
	@Transient
	private MultipartFile file;
	
	

	private int prd_Count;
	
	private double prd_Unit_Measure;
	
	private String prd_Description;
	
	private boolean prd_Promo;

	private String category;

	
	
	
	
	
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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
		
}
