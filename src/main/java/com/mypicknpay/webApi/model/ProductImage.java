package com.mypicknpay.webApi.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="tbl_Images")
public class ProductImage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="img_Id")
	private Long id;
	
	
	private String fileName;
	
	
	private String fileType;
	
	
	@Lob
	private byte[] imgSize;


	
	
	public ProductImage() {
		
	}
	
	
	public ProductImage(String fileName, String fileType, byte[] imgSize) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.imgSize = imgSize;
	}




	public Long getId() {
		return id;
	}

	
	

	public void setId(Long id) {
		this.id = id;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public byte[] getImgSize() {
		return imgSize;
	}


	public void setImgSize(byte[] imgSize) {
		this.imgSize = imgSize;
	}


	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", imgSize="
				+ Arrays.toString(imgSize) + "]";
	}
	
	
   
	
	
}
